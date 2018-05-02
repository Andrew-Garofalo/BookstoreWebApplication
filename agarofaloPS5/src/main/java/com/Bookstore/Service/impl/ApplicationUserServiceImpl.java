package com.Bookstore.Service.impl;

import com.Bookstore.Model.ApplicationUser;
import com.Bookstore.Repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Override
    public ApplicationUser findUserByUserName(String username) {
        return applicationUserRepository.findUserByUserName(username);
    }
}
