package dev.ifrs.webservices;

import java.util.List;

import dev.ifrs.model.Booking;
import dev.ifrs.model.User;
import jakarta.annotation.security.RolesAllowed;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/booking") // Caminho para acessar o webservice
@Transactional
/**
 * Essa classe representa um web service que gerencia os bookings (reservas)
 * para que clientes possam brincar com os gatinhos do cat café..
 * Contem métodos para adicionar, listar, pesquisar, atualizar e remover
 * bookings.
 * Apenas usuários com a role "Admin" podem adicionar, atualizar e remover
 * bookings.
 * Usuários com a role "User" podem listar, pesquisar e adicionar um booking
 * para si.
 * O web service usa o formato JSON para trocar dados com o cliente, além do
 * RESTful Webservices API e Jakarta Persistence API para acesso ao banco de
 * dados.
 */
public class BookingWS {

    // Adiciona um novo booking no "calendário" do cat café
    @POST
    @Path("/add")
    @RolesAllowed({ "Admin" })
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Booking addBooking(@FormParam("startTime") String startTime, @FormParam("endTime") String endTime,
            @FormParam("timeframeAvailable") boolean isTimeframeAvailable) {
        Booking booking = new Booking();

        booking.setStartTime(startTime);
        booking.setEndTime(endTime);
        booking.setTimeframeAvailable(isTimeframeAvailable);
        booking.persist();
        return booking;

    }

    // Lista todos os bookings
    @GET
    @Path("/list")
    @RolesAllowed({ "User, Admin" })
    @Produces(MediaType.APPLICATION_JSON)
    public List<Booking> list() {
        return Booking.listAll();
    }

    // Deleta um booking pelo id
    @DELETE
    @Path("/delete/{id}")
    @RolesAllowed({ "Admin" })
    @Produces(MediaType.APPLICATION_JSON)
    public Booking delete(@PathParam("id") Long id) {
        Booking booking = Booking.findById(id);
        if (booking != null) {
            booking.delete();
            return booking;
        } else {
            return null;

        }
    }

    // Atualiza um booking pelo id
    @PUT
    @Path("/edit")
    @RolesAllowed({ "Admin" })
    @Produces(MediaType.APPLICATION_JSON)
    public Booking edit(@FormParam("startTime") String starTime, @FormParam("endTime") String endTime,
            @FormParam("timeframeAvailable") boolean isTimeframeAvailable) {
        Booking booking = new Booking();
        booking.setStartTime(starTime);
        booking.setEndTime(endTime);
        booking.setTimeframeAvailable(isTimeframeAvailable);
        booking.persist();
        return booking;
    }

    // Liga um booking a um usuário
    @PUT
    @Path("/booking/{id}")
    @RolesAllowed({ "User, Admin" })
    @Produces(MediaType.APPLICATION_JSON)
    public Booking userBooking(@FormParam("user_id") Long user_id, @FormParam("booking_id") Long booking_id) {
        Booking booking = Booking.findById(booking_id);
        if (booking.isTimeframeAvailable() == true) {
            User user = User.findById(user_id);
            if (user == null)
                throw new BadRequestException("User not found, not possible to booking");

            booking.setUser(user);
            return booking;
        } else {
            return null;
        }
    }

    // Lista bookings por usuário
    @GET
    @Path("/list/user/{id}")
    @RolesAllowed({ "User, Admin" })
    @Produces(MediaType.APPLICATION_JSON)
    public List<Booking> listByUserId(@PathParam("id") Long id) {
        return Booking.find("user_id", id).list();
    }

}