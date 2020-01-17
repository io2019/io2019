package net.io.kino.service;

import net.io.kino.model.Manager;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;


public interface AuthenticationManager {
    boolean login(String username, String password) throws InvalidKeySpecException, NoSuchAlgorithmException;
    boolean logout(Manager user);
    boolean authenticate(String username, String password) throws InvalidKeySpecException, NoSuchAlgorithmException;
}
