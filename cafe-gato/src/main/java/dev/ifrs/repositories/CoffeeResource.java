package dev.ifrs.repositories;

import jakarta.ws.rs.core.MediaType;
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
import jakarta.annotation.security.RolesAllowed;
import java.util.List;
import dev.ifrs.model.*;

@Path("/coffees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class CoffeeResource {

    @GET
    public List<Coffee> getAllCoffees() {
        return Coffee.listAll();
    }

    @GET
    @Path("/{id}")
    public Coffee getCoffee(@PathParam("id") Long id) {
        return Coffee.findById(id);
    }

}
