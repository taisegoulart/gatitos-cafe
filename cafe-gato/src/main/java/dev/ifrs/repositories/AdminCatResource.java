package dev.ifrs.repositories;


import java.util.List;

import jakarta.annotation.security.RolesAllowed;
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
import dev.ifrs.model.*;



@Path("/admin/cats")
@Produces(MediaType.APPLICATION_JSON) //sempre tem que mandar json e produzir jason
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@RolesAllowed("admin")
public class AdminCatResource {

    @GET
    public List<Cat> getAllCats() {
        return Cat.listAll();
    }

    @POST
    public Response addCat(Cat cat) {
        cat.persist();
        return Response.status(Response.Status.CREATED).entity(cat).build();
        
    }

    @PUT
    @Path("/{id}")
    public Cat updateCat(@PathParam("id") Long id, Cat updatedCat) {
        Cat cat = Cat.findById(id);
        if (cat != null) {
            cat.setName(updatedCat.getName());
            cat.setAge(updatedCat.getAge());
            cat.setSex(updatedCat.getSex());
            cat.setBreed(updatedCat.getBreed());
            cat.setBio(updatedCat.getBio());
        }
        return cat;
        //pensar sobre a persistência
    }

 @DELETE
    @Path("/{id}")
    public Response deleteCat(@PathParam("id") Long id) {
        Cat cat = Cat.findById(id);
        if (cat != null) {
            cat.delete();
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
