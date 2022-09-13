package fr.istic.taa.jaxrs.exception;

import javax.ws.rs.core.Response;

public interface ExceptionMapper <E extends Throwable>{
    Response toResponse(Exception E);
}
