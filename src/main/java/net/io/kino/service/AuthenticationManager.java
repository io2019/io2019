package net.io.kino.service;

public interface AuthenticationManager {
    boolean login(String username, String password);
    boolean authenticate(String username, String password);
}
