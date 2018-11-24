package pl.raknroll.raknrollpdf.domain;

import lombok.AllArgsConstructor;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.encoding.Encoding;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@AllArgsConstructor
class PdfPopulater {

    void populateAndCopy(PdfInput pdfInput, InputStream pdfInputStream, OutputStream pdfOutputStream) throws IOException {
        PDDocument pdfDocument = PDDocument.load(pdfInputStream);

        pdfDocument.getNumberOfPages();

        setField(pdfDocument, "firstName", pdfInput.getFirstName() + "!");
        pdfDocument.save(pdfOutputStream);
        pdfDocument.close();
    }

    private void setField(PDDocument pdfDocument, String name, String value) throws IOException {
        PDDocumentCatalog docCatalog = pdfDocument.getDocumentCatalog();
        PDAcroForm acroForm = docCatalog.getAcroForm();
        configureFont(acroForm, pdfDocument);
        PDField field = acroForm.getField(name);
        if (field != null) {
            field.setValue(value);
            field.setReadOnly(true);
        } else {
            System.err.println("No field found with name:" + name);
        }
    }

    private void configureFont(PDAcroForm acroForm, PDDocument pdfDocument) throws IOException {
        PDResources resources = acroForm.getDefaultResources();
        if (resources == null)
            resources = new PDResources();

        try(InputStream fontStream = PdfPopulater.class.getResourceAsStream("/Dosis-Bold.ttf")){
            PDType0Font font = PDType0Font.load(pdfDocument, fontStream, false);
            resources.add(font);
            resources.put(COSName.getPDFName("Helvetica"), font);
            acroForm.setDefaultResources(resources);
        }
    }
}