package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.domain.Pet;
import fr.istic.taa.jaxrs.service.PetService;
import io.swagger.v3.oas.annotations.Parameter;

import java.util.List;

@Path("/pet")
@Produces({"application/json", "application/xml"})
public class PetResource {
  private PetService petService;

  public PetResource() {
    this.petService = new PetService();
  }

  @GET
  public List<Pet> getAllPet() {
    return petService.getAll();
  }

  @GET
  @Path("/{petId}")
  public Pet getPetById(@PathParam("petId") Long petId)  {
      // return pet
    System.out.println("coco");
     return new Pet();
  }

  @POST
  @Consumes("application/json")
  public Response addPet(
      @Parameter(description = "Pet object that needs to be added to the store", required = true) Pet pet) {
    // add pet
    return Response.ok().entity("SUCCESS").build();
  }
}