package com.example.exportresponseasjsonfile.controllers;

import com.example.exportresponseasjsonfile.services.ExportIntermediaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/export")
public class ExportIntermediaryController {

    @Autowired
    private ExportIntermediaryService service;

    @GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }

    @GetMapping("/test")
    public void testExportIntermediary() {
         service.exporResposeToFile();
    }

}
