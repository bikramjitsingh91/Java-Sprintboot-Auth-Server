package com.project.appinfoservice.services;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class AppServciesImp implements AppServices{

    public void generatePDFFromHTML() throws IOException, DocumentException {
        generatePDFFromHTML("D:\\myRepo\\JavaEE\\appinfoservice\\src\\main\\resources\\templates\\htmlForm.html");

    }

    public ByteArrayInputStream generatePDFInputStreamFromHTML() throws IOException, DocumentException {
        return
                generatePDFInputStreamFromHTML
                        ("D:\\myRepo\\JavaEE\\appinfoservice\\src\\main\\resources\\templates\\htmlForm.html");

    }

    private static void generatePDFFromHTML(String filename) {
        try{

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document,
          new FileOutputStream("D:\\myRepo\\JavaEE\\appinfoservice\\src\\html.pdf"));
        document.open();
        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
          new FileInputStream(filename));
        document.close();
        }catch (Exception ex){
            int i = 0;
            System.out.println(ex.getMessage());
        }
    }

     private static ByteArrayInputStream generatePDFInputStreamFromHTML(String filename) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try{
        PdfWriter writer = PdfWriter.getInstance(document,out);
        document.open();
        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
          new FileInputStream(filename));
        document.close();

        }catch (Exception ex){
            int i = 0;
            System.out.println(ex.getMessage());
        }
        return new ByteArrayInputStream(out.toByteArray());
    }
}
