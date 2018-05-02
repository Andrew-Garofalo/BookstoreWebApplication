package com.Bookstore.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {

    @GetMapping(value = "/contact-us")
    public String contactUs() {
        return "contact-us";
    }

}