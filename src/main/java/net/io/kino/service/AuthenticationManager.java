package net.io.kino.service;

import net.io.kino.model.User;


public interface AuthenticationManager {
    boolean login(User user) throws Exception;
    boolean logout(User user);
    boolean authenticate(User user) throws Exception;
}
