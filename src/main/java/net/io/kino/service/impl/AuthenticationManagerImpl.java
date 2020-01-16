package net.io.kino.service.impl;

import net.io.kino.repository.ManagersRepository;
import net.io.kino.model.User;
import net.io.kino.service.AuthenticationManager;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;

public class AuthenticationManagerImpl implements AuthenticationManager {

    private static final int iterations = 20*1000;
    private static final int saltLen = 32;
    private static final int desiredKeyLen = 256;

    @Autowired
    private ManagersRepository managers;

    @Override
    public boolean login(User user) throws Exception {
        if(authenticate(user)) {
            user.setStatus(true);
            return true;
        }
        else {
            user.setStatus(false);
            return false;
        }

    }

    @Override
    public boolean logout(User user) {
        if(user.getStatus()){
            user.setStatus(false);
            return true;
        }
        else{
            return false;
        }
    }

    // check if hash of a given password corresponds with a password in database
    @Override
    public boolean authenticate(User user) throws Exception {
        User found = managers.getOne(user.getID());
        String stored = found.getPassword();

        String[] saltAndHash = stored.split("\\$");
        if (saltAndHash.length != 2) {
            throw new IllegalStateException(
                    "Stored password doesn't have a form 'salt$hash'");
        }
        String hashOfInput = hash(user.getPassword(), Base64.decodeBase64(saltAndHash[0]));
        return hashOfInput.equals(saltAndHash[1]);
    }

    // compute salted PBKDF2 hash of given password
    public static String getSaltedHash(String password) throws Exception {
        byte[] salt = SecureRandom.getInstance("SHA1PRNG").generateSeed(saltLen);
        // store the salt with the password
        return Base64.encodeBase64String(salt) + "$" + hash(password, salt);
    }


    private static String hash(String password, byte[] salt) throws Exception {
        if (password == null || password.length() == 0)
            throw new IllegalArgumentException("Empty passwords are not supported.");
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        SecretKey key = f.generateSecret(new PBEKeySpec(
                password.toCharArray(), salt, iterations, desiredKeyLen));
        return Base64.encodeBase64String(key.getEncoded());
    }


}
