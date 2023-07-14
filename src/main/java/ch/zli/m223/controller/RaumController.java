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

import ch.zli.m223.model.Raum;
import ch.zli.m223.service.RaumService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/raum")
@Tag(name = "Raum", description = "Handling of raum")
@RolesAllowed({ "Admin" })
public class RaumController {

    @Inject
    RaumService raumService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all raeume.", description = "Returns a list of all raeume.")
    public List<Raum> index() {
        return raumService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new raum.", description = "Creates a new raum and returns the newly added raum.")
    public Raum create(@Valid Raum raum) {
        return raumService.createRaum(raum);
    }

    @Path("/{raumId}")
    @DELETE
    @Operation(summary = "Deletes an raum.", description = "Deletes an raum by its id.")
    public void delete(@PathParam("raumId") int raumId) {
        raumService.deleteRaum(raumId);
    }

    @Path("/{raumId}")
    @PUT
    @Operation(summary = "Updates an raum.", description = "Updates an raum by its id.")
    public Raum update(@PathParam("raumId") int raumId, @Valid Raum raum) {
        return raumService.updateRaum(raumId, raum);
    }

}