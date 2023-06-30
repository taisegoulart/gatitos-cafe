package dev.ifrs.client;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import dev.ifrs.model.User;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RegisterRestClient(baseUri = "http://localhost:8082/user") //lugar que ele vai se comunicar
public interface UserClient {
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/findbylogin")
    //public String findByLogin(String login); //sugestão do copilot
    public User findByLogin(@FormParam("login")String login, @FormParam("senha")String senha); 
}
