package dev.ifrs.repositories;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.annotation.security.RolesAllowed;
import dev.ifrs.model.*;

import jakarta.ws.rs.Produces;


import java.util.List;

import dev.ifrs.model.Booking;

@Path("/api/bookings")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class UserBookingResource {

    @GET
    public List<Booking> getAllBookings() {
        return Booking.listAll();
    }

    @POST
    public Response createBooking(Booking booking) {
        // Logic to check availability and create the booking
        // ...

        booking.persist();
        return Response.status(Response.Status.CREATED).entity(booking).build();
    }
}
