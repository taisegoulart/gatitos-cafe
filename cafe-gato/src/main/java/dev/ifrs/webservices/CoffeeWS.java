package dev.ifrs.webservices;

import java.util.List;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;

import dev.ifrs.model.*;

@Path("/coffees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
/**
 * Essa classe representa the RESTful web service que gerencia os cafés.
 * Possui endpoint para adicionar, editar, deletar e pesuisar por cafés.
 * A classe possui a anotação @Path para especificar a base URI do servidor que
 * fará conexão e também uma anotação @Produces/@Consumes que especifica o tipo
 * de mídia consumido e produzido pelo webservice.
 * A anotação @Transactional garante que as operações são executadas por meio de
 * uma transação.
 */
public class CoffeeWS {

    // Adiciona um café
    @POST
    @Path("/add")
    @RolesAllowed({ "Admin" })
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Coffee addCoffee(@FormParam("name") String name, @FormParam("description") String description,
            @FormParam("price") double price) {
        Coffee coffee = new Coffee();

        coffee.setName(name);
        coffee.setDescription(description);
        coffee.setPrice(price);

        coffee.persist();
        return coffee;
    }

    // Lista todos os cafés
    @GET
    @PermitAll
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Coffee> getAllCoffees() {
        return Coffee.listAll();
    }

    // Pesquisa um café pelo id
    @GET
    @Path("/find/{id}")
    @RolesAllowed({ "User", "Admin" })
    @Produces(MediaType.APPLICATION_JSON)
    public Coffee findCoffee(@PathParam("id") Long id) {
        return Coffee.findById(id);
    }

    // Atualiza um café
    @PUT
    @Path("/update/{id}")
    @RolesAllowed({ "Admin" })
    public Coffee updateCoffee(@PathParam("id") Long id, Coffee updatedCoffee) {
        Coffee coffee = Coffee.findById(id);
        if (coffee != null) {
            coffee.setName(updatedCoffee.getName());
            coffee.setDescription(updatedCoffee.getDescription());
            coffee.setPrice(updatedCoffee.getPrice());
        }
        return coffee; // testar se funciona
    }

    // Deleta um café
    @DELETE
    @RolesAllowed({ "Admin" })
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Coffee deleteCoffee(@PathParam("id") Long id) {
        Coffee coffee = Coffee.findById(id);
        if (coffee != null) {
            coffee.delete();
            return coffee;
        } else {
            return null;

        }
    }

}
