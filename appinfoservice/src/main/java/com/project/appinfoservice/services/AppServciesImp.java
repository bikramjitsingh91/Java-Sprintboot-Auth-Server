package com.project.appinfoservice.services;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;


import java.io.*;

@Service
public class AppServciesImp implements AppServices{

    public void generatePDFFromHTML() throws IOException, DocumentException {
        generatePDFFromHTML("D:\\myRepo\\JavaEE\\appinfoservice\\src\\main\\resources\\templates\\htmlForm.html");

    }

    public ByteArrayInputStream generatePDFInputStreamFromHTML() throws IOException, DocumentException {
//        return
//                generatePDFInputStreamFromHTML
//                        ("D:\\myRepo\\JavaEE\\appinfoservice\\src\\main\\resources\\templates\\htmlForm.html");
       // return generatePDFWithImageBackgroundInputStreamFromHTML("D:\\myRepo\\JavaEE\\appinfoservice\\src\\main\\resources\\templates\\htmlForm.html");
        String html = parseThymeleafTemplate();
        return generateThlyPdfFromHtml(html);

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

    private static ByteArrayInputStream generatePDFWithImageBackgroundInputStreamFromHTML(String filename) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try{
            PdfWriter writer = PdfWriter.getInstance(document,out);
            document.open();
//            XMLWorkerHelper.getInstance().parseXHtml(writer, document,
//                    new FileInputStream(filename));
//            document.close();

            Image background = Image.getInstance("D:\\myRepo\\JavaEE\\appinfoservice\\src\\main\\resources\\templates\\blueColor.png");

            document.open();// open a PDF file for editing

            background.setAlignment(Image.UNDERLYING);
            background.setAbsolutePosition(0-50, 0-50);
            background.scaleAbsolute(595-100, 842-100);
            document.add(background);

            XMLWorkerHelper.getInstance().parseXHtml(writer, document,
                    new FileInputStream(filename));
            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
            Chunk chunk = new Chunk("Hello World", font);


            document.add(chunk);
            document.close();

        }catch (Exception ex){
            int i = 0;
            System.out.println(ex.getMessage());
        }
        return new ByteArrayInputStream(out.toByteArray());
    }

    private String parseThymeleafTemplate() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);


        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        Context context = new Context();
        context.setVariable("to", "Baeldung");
        return templateEngine.process("Theamlyf", context);
    }

    public ByteArrayInputStream generateThlyPdfFromHtml(String html) throws IOException, DocumentException {
        String outputFolder = System.getProperty("user.home") + File.separator + "thymeleaf.pdf";
        OutputStream outputStream = new ByteArrayOutputStream();//new FileOutputStream(outputFolder);

        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);
        renderer.layout();
        renderer.createPDF(outputStream);

        outputStream.close();
        return new ByteArrayInputStream(((ByteArrayOutputStream) outputStream).toByteArray());
    }
}
