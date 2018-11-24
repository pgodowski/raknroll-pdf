package pl.raknroll.raknrollpdf.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.IOException;

import static javax.ws.rs.core.Response.Status.OK;


@Component
@Path("/")
public class PdfGeneratorContoller {

    @Autowired
    private PdfGenerator pdfGenerator;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/healthcheck")
    public Response healthCheck() {
        return Response.status(OK).entity(new PdfResponse("I'm running")).build();
    }

    @GET
    @Produces("application/pdf")
    @Path("/thankyou")
    public Response uploadFile(@BeanParam final PdfInput pdfInput) throws IOException {
        return Response.status(OK).entity(pdfGenerator.generate(pdfInput)).build();
    }

}
