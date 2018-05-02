package com.Bookstore.Service;

import com.Bookstore.Model.ApplicationUser;
import com.Bookstore.Model.Security.SecurityUser;
import com.Bookstore.Service.impl.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class MobyDickUserDetailsService implements UserDetailsService {

    @Autowired
    private ApplicationUserService applicationUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser user = applicationUserService.findUserByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username not found: " + username);
        }
        return new SecurityUser(user);
    }
}