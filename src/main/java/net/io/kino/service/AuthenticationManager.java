package net.io.kino.service;

import net.io.kino.model.Manager;


public interface AuthenticationManager {
    boolean login(String username, String password) throws Exception;
    boolean logout(Manager user);
    boolean authenticate(String username, String password) throws Exception;
}
