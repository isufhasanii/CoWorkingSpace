package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.mail.MessagingException;
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

import ch.zli.m223.model.Buchung;
import ch.zli.m223.service.BuchungService;
import ch.zli.m223.service.EmailService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/buchung")
@Tag(name = "Buchung", description = "Handling of buchung")
@RolesAllowed({ "User", "Admin" })
public class BuchungController {

    @Inject
    BuchungService buchungService;
    private EmailService emailService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all buchung.", description = "Returns a list of all buchung.")
    public List<Buchung> index() {
        return buchungService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new buchung.", description = "Creates a new buchung and returns the newly added buchung.")
    public Buchung create(@Valid Buchung buchung) {
        try {
            emailService.sendBookingConfirmationEmail(buchung.getMember());
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return buchungService.createBuchung(buchung);
    }

    @Path("/{buchungId}")
    @DELETE
    @Operation(summary = "Deletes an buchung.", description = "Deletes an buchung by its id.")
    public void delete(@PathParam("buchungId") int buchungId) {
        buchungService.deleteBuchung(buchungId);
    }

    @Path("/{buchungId}")
    @PUT
    @Operation(summary = "Updates an buchungId.", description = "Updates an buchung by its id.")
    public Buchung update(@PathParam("buchungId") int buchungId, @Valid Buchung buchung) {
        return buchungService.updateBuchung(buchungId, buchung);
    }

}