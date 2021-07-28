package org.grow90.finmlapi.controller;

import org.grow90.finmlapi.entity.Company;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    @GetMapping
    public String getCompanies(){
        return "FinML API server";
    }
}
