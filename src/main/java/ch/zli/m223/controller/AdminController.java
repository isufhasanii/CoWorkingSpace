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

import ch.zli.m223.model.Admin;
import ch.zli.m223.model.Mitglied;
import ch.zli.m223.service.AdminService;
import ch.zli.m223.service.MitgliedService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Entry;
import ch.zli.m223.service.EntryService;

@Path("/admin")
@Tag(name = "Admin", description = "Handling of admin")
@RolesAllowed({ "Admin" })
public class AdminController {

    @Inject
    AdminService adminService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all admin.", description = "Returns a list of all admin.")
    public List<Admin> index() {
        return adminService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new admin.", description = "Creates a new admin and returns the newly added admin.")
    public Admin create(@Valid Admin admin) {
        return adminService.createAdmin(admin);
    }

    @Path("/{adminId}")
    @DELETE
    @Operation(summary = "Deletes an admin.", description = "Deletes an admin by its id.")
    public void delete(@PathParam("adminId") int adminId) {
        adminService.deleteAdmin(adminId);
    }

    @Path("/{adminId}")
    @PUT
    @Operation(summary = "Updates an admin.", description = "Updates an admin by its id.")
    public Admin update(@PathParam("adminId") int adminId, @Valid Admin admin) {
        return adminService.updateAdmin(adminId, admin);
    }

}