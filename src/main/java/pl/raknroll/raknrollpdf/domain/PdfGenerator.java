package pl.raknroll.raknrollpdf.domain;

import lombok.AllArgsConstructor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@AllArgsConstructor
class PdfGenerator {
    private PdfPopulater pdfPopulater;

    byte[] generate(PdfInput pdfInput) throws IOException {
        try (InputStream template = PdfGenerator.class.getResourceAsStream("/template.pdf")){
            final ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream();
            pdfPopulater.populateAndCopy(pdfInput, template, pdfOutputStream);
            return pdfOutputStream.toByteArray();
        }
    }
}
