package net.io.kino.service;

import org.springframework.security.core.Authentication;

public interface AuthenticationManager {
    Authentication login(String username, String password);
    boolean authenticate(String username, String password);
}
