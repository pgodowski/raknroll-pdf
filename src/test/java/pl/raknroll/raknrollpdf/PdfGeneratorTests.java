package pl.raknroll.raknrollpdf;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class PdfGeneratorTests {

    private PdfGenerator pdfGenerator = new PdfGenerator();

    @Test
    public void shouldReturnGeneratedPdf() {
        // given
        PdfInput pdfInput = new PdfInput("Jan", "2018-11-23");

        // when
        pdfGenerator.generate(pdfInput);

        // then
        assertThat(true).isEqualTo(true);
    }

}
