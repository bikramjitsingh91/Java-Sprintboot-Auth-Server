package com.project.appinfoservice.services;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.SneakyThrows;

public class PDFBackground extends PdfPageEventHelper {

    @SneakyThrows
    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        Image background = Image.getInstance("D:\\myRepo\\JavaEE\\appinfoservice\\src\\main\\resources\\templates\\blueColor.png");
        // This scales the image to the page,
        // use the image's width & height if you don't want to scale.
        float width = document.getPageSize().getWidth();
        float height = document.getPageSize().getHeight();
        writer.getDirectContentUnder()
                .addImage(background, width, 0, 0, height, 0, 0);
    }
}
