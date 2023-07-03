package dev.ifrs.web;

import java.util.Arrays;
import java.util.HashSet;

import org.eclipse.microprofile.jwt.Claims;

import io.smallrye.jwt.build.Jwt;
import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import dev.ifrs.client.UserClient;
import dev.ifrs.model.User;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;

import jakarta.ws.rs.WebApplicationException;

/**
 * Essa classe representa o login web service.
 */
@Path("/login")
public class LoginWS {
    // Injeção de dependência do cliente REST
    @Inject
    @RestClient
    /**
     * O UserClient é usado para comunicação com o servidor.
     */
    UserClient user;

    /**
     * Método para gerar o token JWT.
     * É necessário que seja passado o login e senha do usuário.
     * Deve ser permitido para todos para poder criar usuários novos.
     * 
     * @param login O login do usuário.
     * @param senha A senha do usuário.
     * @return O token JWT gerado.
     * @throws WebApplicationException Se o login ou senha estiverem incorretos.
     */
    @POST
    @PermitAll
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String generate(@FormParam("login") String login, @FormParam("senha") String senha)
            throws WebApplicationException {
        User meuUser = user.findByLogin(login, senha);
        String myRoleString;
        if (meuUser.isAdmin()) {
            myRoleString = "Admin";
        } else {
            myRoleString = "User";
        }
        if (meuUser != null && meuUser.getPassword().equals(senha)) {

            return Jwt.issuer("http://localhost:8081") // string para validar JWT
                    .upn(login)
                    .groups(new HashSet<>(Arrays.asList(myRoleString))) // grupo do usuário
                    .claim(Claims.full_name, "usuario")
                    .claim("blabla", "oi")
                    .sign();

        } else {
            throw new WebApplicationException("Login ou senha incorretos", 403);
        }
    }

}
