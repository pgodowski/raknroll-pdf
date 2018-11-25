package pl.raknroll.raknrollpdf.domain;

import org.apache.pdfbox.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.IOException;
import java.io.InputStream;

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
    @Produces("application/txt")
    @Path("/wakemydyno.txt")
    public Response wakeupdyno() throws IOException {
        try(InputStream is = PdfGeneratorContoller.class.getResourceAsStream("/wakemydyno.txt")){
            return Response.status(OK).entity(IOUtils.toByteArray(is)).build();
        }
    }

    @GET
    @Produces("application/pdf")
    @Path("/thankyou")
    public Response uploadFile(@Valid @BeanParam final PdfInput pdfInput) throws IOException {
        return Response.status(OK).entity(pdfGenerator.generate(pdfInput)).build();
    }

}
