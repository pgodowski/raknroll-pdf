package pl.raknroll.raknrollpdf.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PdfGeneratorConfig{

    @Bean
    public PdfGenerator pdfGenerator() {
        return new PdfGenerator(new PdfPopulater());
    }
}

