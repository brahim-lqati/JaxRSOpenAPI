package fr.istic.taa.jaxrs.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundException extends Throwable implements ExceptionMapper<NotFoundException> {

    @Override
    public Response toResponse(Exception E) {
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
