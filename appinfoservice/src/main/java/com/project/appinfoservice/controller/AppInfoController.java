package com.project.appinfoservice.controller;

import com.itextpdf.text.DocumentException;
import com.project.appinfoservice.services.AppServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@CrossOrigin
@RestController
public class AppInfoController {
    private AppServices appServices;

    @Autowired
    public AppInfoController(AppServices appServices){
        this.appServices = appServices;
    }

    @GetMapping(value = "/appinfo")
    public String getAppInfo() throws IOException, DocumentException {
        appServices.generatePDFFromHTML();
        return "DreamApp";
    }

    @GetMapping(value = "/openappinfo")
    public String getOpenApiAppInfo() throws IOException, DocumentException {
        appServices.generatePDFFromHTML();
        return "DreamApp";
    }

    @CrossOrigin
    @RequestMapping(value = "/pdfdownload", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> generatedPDF() throws IOException, DocumentException {
        ByteArrayInputStream bis = appServices.generatePDFInputStreamFromHTML();

        var headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=test.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}

//https://zetcode.com/springboot/servepdf/