package com.example.FirstSecurityApp;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Main {
    public Main(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
       PasswordEncoder passwordEncoder1 = new BCryptPasswordEncoder();


        System.out.println();
        System.out.println(passwordEncoder1.encode("a").equals("$2a$10$75KsO/wvqrLrqhR9zvETuuWrTiLNL13Q8P5DvyPrgT53yAH0WYMiy"));
    }

    private final PasswordEncoder passwordEncoder;

}
