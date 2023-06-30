package dev.ifrs.webservices;

import java.util.List;

import jakarta.annotation.security.RolesAllowed;
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
import jakarta.ws.rs.core.Response;
import dev.ifrs.model.*;



@Path("/cats") //preciso que o path seja admin? Será que o roles allowed já não me garante a edição?
@Transactional

public class CatWS {


//Método para adicionar um gato
@POST
@Path("/add")
@RolesAllowed({"Admin"})
 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
 @Produces(MediaType.APPLICATION_JSON)
 public Cat addCat(@FormParam("name") String name, @FormParam("age") int age, @FormParam("sex") String sex, @FormParam("breed") String breed, @FormParam("bio") String bio, @FormParam("forAdoption") boolean forAdoption){
Cat cat = new Cat();
cat.setName(name);
cat.setAge(age);
cat.setBreed(breed);
cat.setSex(sex);
cat.setBio(bio);
cat.setForAdoption(forAdoption);
cat.persist();
return cat;
 }
 
//Método para listar todos os gatos
    @GET
    @Path("/list")
    @RolesAllowed({"User", "Admin"})
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cat> listAllCats() {
        return Cat.listAll();
    }


//Método para procurar um gato específico pela id
@GET
@Path("/find/{id}")
@RolesAllowed({"User", "Admin"})
@Produces(MediaType.APPLICATION_JSON)
public Cat findCat(@PathParam("id") Long id){
    return Cat.findById(id);
}

//Método para editar um gato
    @PUT
    @Path("/edit/{id}")
    @RolesAllowed({"Admin"})
    @Produces(MediaType.APPLICATION_JSON)
    public Cat editCat(@FormParam("id") Long id, @FormParam("name") String name, @FormParam("age") int age, @FormParam("sex") String sex, @FormParam("breed") String breed, @FormParam("bio") String bio, @FormParam("forAdoption") boolean forAdoption){
    Cat cat =Cat.findById(id);
cat.setName(name);
cat.setAge(age);
cat.setBreed(breed);
cat.setSex(sex);
cat.setBio(bio);
cat.setForAdoption(forAdoption);
cat.persist();
return cat;
}

   /*  public Cat updateCat(@PathParam("id") Long id, Cat updatedCat) {
        Cat cat = Cat.findById(id);
        if (cat != null) {
            cat.setName(updatedCat.getName());
            cat.setAge(updatedCat.getAge());
            cat.setSex(updatedCat.getSex());
            cat.setBreed(updatedCat.getBreed());
            cat.setBio(updatedCat.getBio());
        }
        return cat;
       
    } // MÉTODO ANTIGO*/

//Método para excluir um gato
 @DELETE
    @Path("/delete/{id}")
    @RolesAllowed({"Admin"})
    @Produces(MediaType.APPLICATION_JSON)
    public Cat deleteCat(@PathParam("id") Long id){
        Cat cat = Cat.findById(id);
        if (cat != null) {
            cat.delete();
            return cat;
        } else {
            return null;
            //Response.status(Response.Status.NOT_FOUND).build();
        }//dúvida: é melhor retornar um gato? ou um response? ou um boolean? ou um void?
    }

} 

    /*public Response deleteCat(@PathParam("id") Long id) {
        Cat cat = Cat.findById(id);
        if (cat != null) {
            cat.delete();
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
} MÉTODO ANTIGO*/
