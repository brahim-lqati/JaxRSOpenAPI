package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.domain.Doctor;
import fr.istic.taa.jaxrs.dto.AddDoctorDTO;
import fr.istic.taa.jaxrs.service.DoctorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/doctors")
@Produces({"application/json"})

public class DoctorResource {
    private final DoctorService doctorService;

    public DoctorResource() {
        this.doctorService = new DoctorService();
    }

    @GET
    @Operation(summary = "find all doctors")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "find doctor by Id",
    responses = {
            @ApiResponse(responseCode = "404", description = "doctor not found")
            @ApiResponse(responseCode = "400", description = )
    })
    public Doctor getDoctorById(@PathParam("id") Long id) {
        return doctorService.findDoctorById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "add new doctor")
    public Response addDoctor(AddDoctorDTO doctorDTO) {
        doctorService.addDoctor(doctorDTO);
        return Response.status(201).entity("success").build();
    }

/*    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Doctor editDoctor() {

    }*/

    @DELETE
    @Path("/{id}")
    @Operation(summary = "delete a doctor by id")
    public Response deleteDoctor(@PathParam("id") Long id) {
        doctorService.deleteDoctor(id);
        return Response.status(200).entity("Doctor deleted with success !").build();
    }
}
