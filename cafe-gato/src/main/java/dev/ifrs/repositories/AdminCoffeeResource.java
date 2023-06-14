package dev.ifrs.repositories;


import java.util.List;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.annotation.security.RolesAllowed;

import dev.ifrs.model.*;

@Path("/admin/coffees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@RolesAllowed("admin")
public class AdminCoffeeResource {
    //pensamento: fazer com formulário?

    @GET
    public List<Coffee> getAllCoffees() {
        return Coffee.listAll();
    }

    @POST
    public Response addCoffee(Coffee coffee) {
        coffee.persist();
        return Response.status(Response.Status.CREATED).entity(coffee).build();
    }

    @PUT
    @Path("/{id}")
    public Coffee updateCoffee(@PathParam("id") Long id, Coffee updatedCoffee) {
        Coffee coffee = Coffee.findById(id);
        if (coffee != null) {
            coffee.setName(updatedCoffee.getName());
            coffee.setDescription(updatedCoffee.getDescription());
            coffee.setPrice(updatedCoffee.getPrice());
        }
        return coffee;
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCoffee(@PathParam("id") Long id) {
        Coffee coffee = Coffee.findById(id);
        if (coffee != null) {
            coffee.delete();
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}


