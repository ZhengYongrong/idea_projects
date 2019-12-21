package com.example.esdemo.login;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class User implements UserDetails {
    private String id;
    private String password;
    private Collection<GrantedAuthority> adminAuth;

    public User(String id, String password, Collection<GrantedAuthority> adminAuth) {
        this.id = id;
        this.password = password;
        this.adminAuth = adminAuth;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return adminAuth;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

}
