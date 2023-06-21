package dev.ifrs;

import java.util.Arrays;
import java.util.HashSet;

import org.eclipse.microprofile.jwt.Claims;

import io.smallrye.jwt.build.Jwt;
import jakarta.annotation.security.PermitAll;


@Path("/auth")
public class Identity {
    @GET
    @Path("/jwt") //caminho do GET
    @PermitAll
    @Produces(MediaType.TEXT_PLAIN)
    public String generate() {
    return Jwt.issuer("http://localhost:8080") //issuer é o emissor do JWT, é quem enviou, não precisa ser um link, é uma string
            .upn("rodrigo@rpmhub.dev") //identificação do usuário
            .groups(new HashSet<>(Arrays.asList("User", "Admin"))) //groups = perfis das roles que a gente quer implementar
            .claim(Claims.full_name, "Rodrigo Prestes Machado") //Claim é um payload, é a carga de dados dados propriamente ditos que tu quer colcoar, a informação propiramente dita que está sendo trafegada
            .sign(); //no padrão do quarkus não consigo dar sign sem chaves
            //nota: as chaves públicas são criadas a partir das chaves privadas, depois converte para um dos formatos aceitados
            //para criar as chaves usar o programa openSSL, a chave pública é distribuída com os outros serviços
            //precisa fazer a propagação do JWT por todo o programa
            //sign serve para o processo de validação, para assinar ele, mostrar que o token é válido, usa a chave privada para assinar
            
}
}


/**package dev.ifrs;

import java.util.Arrays;
import java.util.HashSet;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import dev.ifrs.Client.UserClient;
import dev.ifrs.Model.User;
import io.smallrye.jwt.build.Jwt;

@Path("/login")
public class IdentityLogin {
    @Inject
    @RestClient
    UserClient user;

    @POST
    // @PermitAll
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String login(@FormParam("login") String login, @FormParam("senha") String senha) {
        User meuUser = user.findByLogin(login);        
        if(meuUser != null){
            if(meuUser.getSenha().equals(senha)){
                //chama jwt
                return (String) Jwt.issuer("http://localhost:8081")
                        .upn(meuUser.getLogin())
                        .groups(new HashSet<>(Arrays.asList("User")))
                        .claim(Claims.full_name, meuUser.getLogin())
                        .sign();
            }
        }
        return "false";
    }
  
}*/