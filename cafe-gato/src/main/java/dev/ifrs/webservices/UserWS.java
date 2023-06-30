package dev.ifrs.webservices;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import dev.ifrs.model.*;

import jakarta.ws.rs.Produces;


import java.util.List;
import dev.ifrs.model.User;
import dev.ifrs.model.Booking;

@Path("/user")
@Transactional
public class UserWS {
    
        @GET
        @Path("/list")
        @RolesAllowed({"User", "Admin"})
        @Produces(MediaType.APPLICATION_JSON)
        public List<User> listAllUsers() {
            return User.listAll();
        }
    
        @POST
        @Path("/add")
        @PermitAll
        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
        @Produces(MediaType.APPLICATION_JSON)
        public User addUser(@FormParam("name") String name, @FormParam("email") String email, @FormParam("password") String password, @FormParam("phone") String phone, @FormParam("login") String login,  @FormParam("isAdmin") boolean isAdmin) {
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
    
        @PUT
        @Path("/update/{id}")
        @RolesAllowed({"Admin"})
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
    
        @DELETE
        @Path("/delete/{id}")
        @RolesAllowed({"Admin"})
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
    
        @GET
        @Path("/find/{id}")
        @RolesAllowed({"User", "Admin"})
        @Produces(MediaType.APPLICATION_JSON)
        public User findUser(@PathParam("id") Long id) {
            User user = User.findById(id);
            return user;
        }


        @POST
        @Path("/findbylogin")
        
        @Produces(MediaType.APPLICATION_JSON)
        public User findUserByLogin(@FormParam("login") String login) {
            User user = User.find("login", login).firstResult();
            return user;
        }


}
