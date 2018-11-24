package pl.raknroll.raknrollpdf.infra;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import pl.raknroll.raknrollpdf.domain.PdfGeneratorContoller;

@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(PdfGeneratorContoller.class);
        //register(MultiPartFeature.class);
        register(CORSFilter.class);
    }
}

