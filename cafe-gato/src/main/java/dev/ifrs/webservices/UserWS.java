package dev.ifrs.webservices;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;

import jakarta.ws.rs.Produces;

import java.util.List;
import dev.ifrs.model.User;

@Path("/user")
@Transactional
/**
 * Essa classe representa o web service da entidade User, que contém endpoints
 * RESTful para gerenciar (adicionar, remover, pesuisar, atualizar) dados dos
 * usuários.
 */
public class UserWS {
    // Lista todos os usuários
    @GET
    @Path("/list")
    @RolesAllowed({ "User", "Admin" })
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> listAllUsers() {
        return User.listAll();
    }

    // Adiciona um usuário
    @POST
    @Path("/add")
    @PermitAll
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public User addUser(@FormParam("name") String name, @FormParam("email") String email,
            @FormParam("password") String password, @FormParam("phone") String phone, @FormParam("login") String login,
            @FormParam("isAdmin") boolean isAdmin) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setLogin(login);
        user.setAdmin(isAdmin);
        user.setPassword(password);

        user.persist();
        return user;
    }

    // Atualiza um usuário
    @PUT
    @Path("/update/{id}")
    @RolesAllowed({ "Admin" })
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public User updateUser(@PathParam("id") Long id, User updatedUser) {
        User user = User.findById(id);
        if (user != null) {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setPhone(updatedUser.getPhone());
            user.setLogin(updatedUser.getLogin());
            user.setAdmin(updatedUser.isAdmin());
        }
        return user;
    }

    // Remove um usuário
    @DELETE
    @Path("/delete/{id}")
    @RolesAllowed({ "Admin" })
    @Produces(MediaType.APPLICATION_JSON)
    public User deletUser(@PathParam("id") Long id) {
        User user = User.findById(id);
        if (user != null) {
            user.delete();
            return user;
        } else {
            return null;
        }
    }

    // Pesquisa um usuário
    @GET
    @Path("/find/{id}")
    @RolesAllowed({ "User", "Admin" })
    @Produces(MediaType.APPLICATION_JSON)
    public User findUser(@PathParam("id") Long id) {
        User user = User.findById(id);
        return user;
    }

    // Pesquisa um usuário pelo login
    @POST
    @Path("/findbylogin")
    @Produces(MediaType.APPLICATION_JSON)
    public User findUserByLogin(@FormParam("login") String login) {
        User user = User.find("login", login).firstResult();
        return user;
    }

}
