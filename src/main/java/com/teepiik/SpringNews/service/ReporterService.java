/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teepiik.SpringNews.service;

import com.teepiik.SpringNews.domain.Reporter;
import com.teepiik.SpringNews.repository.ReporterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author teepiik
 */
@Service
public class ReporterService {
    @Autowired
    private  ReporterRepository reporterRepository;
    
    public Long addReporter(Reporter reporter) {
        return reporterRepository.save(reporter).getId();
    }
}
