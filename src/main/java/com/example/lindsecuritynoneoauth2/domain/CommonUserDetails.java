package com.example.lindsecuritynoneoauth2.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author lind
 * @date 2024/4/17 8:56
 * @since 1.0.0
 */
@Data
@Builder(toBuilder = true)
public class CommonUserDetails implements UserDetails {
    private String username;
    private String password;
    private Integer status;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.getStatus().equals(1);
    }
}
