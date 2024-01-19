package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("src/main/java/org/example/PDFA2B.pdf");
        PDDocument doc = PDDocument.load(file);
        PDDocumentCatalog docCatalog = doc.getDocumentCatalog();
        PDAcroForm acroForm = docCatalog.getAcroForm();

        PDField vornameField = acroForm.getField("Vorname");
        PDField nachnameField = acroForm.getField("Nachname");
        vornameField.setValue("Hello");
        nachnameField.setValue("World");

        doc.save("src/main/java/org/example/filled.pdf");
        doc.close();
    }
}