package pl.raknroll.raknrollpdf.infra;

import pl.raknroll.raknrollpdf.domain.PdfResponse;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class AppExceptionMapper implements ExceptionMapper<Exception> {

    public Response toResponse(Exception ex) {
        return Response.status(500)
                       .entity(new PdfResponse("Error"))
                       .type(MediaType.APPLICATION_JSON).
                               build();
    }

}
