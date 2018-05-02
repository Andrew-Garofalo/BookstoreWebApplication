package com.Bookstore.Service.impl;

import com.Bookstore.Model.ApplicationUser;

public interface ApplicationUserService {
    ApplicationUser findUserByUserName(String username);
}