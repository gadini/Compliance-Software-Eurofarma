package com.github.gadini.complainceSoftware.controller;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class PdfController {

    @PostMapping("/extract-text")
    public String extractTextFromPdf(@RequestParam("file") MultipartFile file) {
        String text = "";

        try (PDDocument document = PDDocument.load(file.getInputStream())) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            text = pdfStripper.getText(document);
        } catch (IOException e) {
            e.printStackTrace();
            return "Erro ao processar o PDF: " + e.getMessage();
        }

        return text;
    }
}
