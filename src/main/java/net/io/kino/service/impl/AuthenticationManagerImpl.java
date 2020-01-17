package net.io.kino.service.impl;

import net.io.kino.repository.ManagersRepository;
import net.io.kino.model.Manager;
import net.io.kino.service.AuthenticationManager;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

public class AuthenticationManagerImpl implements AuthenticationManager {

    private static final int iterations = 20*1000;
    private static final int saltLen = 32;
    private static final int desiredKeyLen = 256;

    @Autowired
    private ManagersRepository managers;

    @Override
    public boolean login(String username, String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
        return authenticate(username, password);
    }

    @Override
    public boolean logout(Manager user) {
        return false;
    }

    // check if hash of a given password corresponds with a password in database
    @Override
    public boolean authenticate(String username, String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
        Manager found = managers.getOne(username);
        String stored = found.getPassword();

        String[] saltAndHash = stored.split("\\$");
        if (saltAndHash.length != 2) {
            throw new IllegalStateException(
                    "Stored password doesn't have a form 'salt$hash'");
        }
        String hashOfInput = hash(password, Base64.decodeBase64(saltAndHash[0]));
        return hashOfInput.equals(saltAndHash[1]);
    }

    // compute salted PBKDF2 hash of given password
    public static String getSaltedHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] salt = SecureRandom.getInstance("SHA1PRNG").generateSeed(saltLen);
        // store the salt with the password
        return Base64.encodeBase64String(salt) + "$" + hash(password, salt);
    }


    private static String hash(String password, byte[] salt) throws InvalidKeySpecException, NoSuchAlgorithmException {
        if (password == null || password.length() == 0)
            throw new IllegalArgumentException("Empty passwords are not supported.");
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        SecretKey key = f.generateSecret(new PBEKeySpec(
                password.toCharArray(), salt, iterations, desiredKeyLen));
        return Base64.encodeBase64String(key.getEncoded());
    }


}
