package dev.ifrs.client;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import dev.ifrs.model.User;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * Essa interface representa um REST client para o Usuário. .
 * Contém métodos para interagir com um Usuário num servidor remoto. 
 */
@RegisterRestClient(baseUri = "http://localhost:8082/user")
public interface UserClient {
    
    /**
     * Encontra um usuário pelo login e senha.
     * 
     * @param login login do usuário.
     * @param senha senha do usuário.
     * @return o usuário encontrado, ou null caso não encontre.
     */
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/findbylogin")
    public User findByLogin(@FormParam("login")String login, @FormParam("senha")String senha); 
}
