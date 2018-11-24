package pl.raknroll.raknrollpdf.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.ws.rs.QueryParam;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class PdfInput {
    @QueryParam("firstName")
    @NotEmpty
    private String firstName;
    @QueryParam("registrationDate")
    private String registrationDate;
}
