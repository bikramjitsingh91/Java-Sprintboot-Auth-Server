package com.project.appinfoservice.services;

import com.itextpdf.text.DocumentException;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public interface AppServices {

    void generatePDFFromHTML() throws IOException, DocumentException;
    ByteArrayInputStream generatePDFInputStreamFromHTML() throws IOException, DocumentException;
}
