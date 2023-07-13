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

import ch.zli.m223.model.Mitglied;
import ch.zli.m223.service.MitgliedService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Entry;
import ch.zli.m223.service.EntryService;

@Path("/mitglied")
@Tag(name = "Mitglied", description = "Handling of mitglied")
@RolesAllowed({ "Admin" })
public class MitgliedController {

    @Inject
    MitgliedService mitgliedService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all mitglieder.", description = "Returns a list of all mitglieder.")
    public List<Mitglied> index() {
        return mitgliedService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new mitglied.", description = "Creates a new mitglied and returns the newly added mitglied.")
    public Mitglied create(@Valid Mitglied mitglied) {
        return mitgliedService.createMitglied(mitglied);
    }

    @Path("/{mitgliedId}")
    @DELETE
    @Operation(summary = "Deletes an mitglied.", description = "Deletes an mitglied by its id.")
    public void delete(@PathParam("mitgliedId") Long mitgliedId) {
        mitgliedService.deleteMitglied(mitgliedId);
    }

    @Path("/{mitgliedId}")
    @PUT
    @Operation(summary = "Updates an mitglied.", description = "Updates an mitglied by its id.")
    public Mitglied update(@PathParam("mitgliedId") int mitgliedId, @Valid Mitglied mitglied) {
        return mitgliedService.updateMitglied(mitgliedId, mitglied);
    }

}