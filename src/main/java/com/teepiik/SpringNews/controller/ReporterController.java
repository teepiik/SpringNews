/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teepiik.SpringNews.controller;

import com.teepiik.SpringNews.repository.ReporterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author teepiik
 */
@Controller
public class ReporterController {
    @Autowired
    private ReporterRepository reporterRepository;
    
    @GetMapping("/reporters")
    public String reporters(Model model) {
        model.addAttribute("reporters", reporterRepository.findAll());
        
        return "reporterListing";
    }
}
