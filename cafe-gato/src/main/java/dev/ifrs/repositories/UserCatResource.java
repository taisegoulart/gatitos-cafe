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
import dev.ifrs.model.*;

import java.util.List;
@Path("/api/cats")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@RolesAllowed("normal-user")
public class UserCatResource {

    @GET
    public List<Cat> getAllCats() {
        return Cat.listAll();
    }

    @GET
    @Path("/{id}")
    public Cat getCat(@PathParam("id") Long id) {
        return Cat.findById(id);
    }

    @GET
    public List<Cat> getAllCoffees() {
        return Coffee.listAll();
    }


    @GET
    @Path("/{id}")
    public Cat getCoffee(@PathParam("id") Long id) {
        return Coffee.findById(id);
    } //Adicionando aqui os cafés também para o usuário poder visualizar!
}
