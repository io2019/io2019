package net.io.kino.service.impl;

import net.io.kino.repository.ManagersRepository;
import net.io.kino.model.Manager;
import net.io.kino.service.AuthenticationManager;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

@Service
public class AuthenticationManagerImpl implements AuthenticationManager {

    private static final int iterations = 20*1000;
    private static final int saltLen = 32;
    private static final int desiredKeyLen = 256;

    @Autowired
    private ManagersRepository managers;

    @Override
    public boolean login(String username, String password) {
        return authenticate(username, password);
    }


    // check if hash of a given password corresponds with a password in database
    @Override
    public boolean authenticate(String username, String password) {
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
    public static String getSaltedHash(String password) {
        byte[] salt = new byte[0];

        try{
           salt = SecureRandom.getInstance("SHA1PRNG").generateSeed(saltLen);
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex.getMessage());
        }
        // store the salt with the password
        return Base64.encodeBase64String(salt) + "$" + hash(password, salt);
    }


    private static String hash(String password, byte[] salt){
        SecretKey key = null;

        try{
            SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            key = f.generateSecret(new PBEKeySpec(
                    password.toCharArray(), salt, iterations, desiredKeyLen));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            System.out.println(ex.getMessage());
        }

        assert key != null;
        return Base64.encodeBase64String(key.getEncoded());
    }


}
