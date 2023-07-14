package ch.zli.m223.controller;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import ch.zli.m223.model.Buchungsanfrage;
import ch.zli.m223.service.BuchungsanfragenService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/buchungsanfragen")
@Tag(name = "Buchungsanfragen", description = "Handling of buchungsanfrage")
@RolesAllowed({ "Admin" })
public class BuchungsanfrageController {

    @Inject
    BuchungsanfragenService buchungsanfragenService;

    @Path("/{buchungsanfrageId}")
    @PUT
    @Operation(summary = "Updates an buchungsanfrage.", description = "Updates an buchungsanfrage by its id.")
    public Buchungsanfrage update(@PathParam("buchungsanfrageId") int buchungsanfrageId, @Valid String status, @Valid Buchungsanfrage buchungsanfrage) {
        return buchungsanfragenService.updateStatus(buchungsanfrageId, status, buchungsanfrage);
    }

}