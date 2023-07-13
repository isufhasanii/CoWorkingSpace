package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ch.zli.m223.model.Buchungsanfrage;
import ch.zli.m223.model.Mitglied;
import ch.zli.m223.service.BuchungsanfragenService;
import ch.zli.m223.service.MitgliedService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Entry;
import ch.zli.m223.service.EntryService;

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