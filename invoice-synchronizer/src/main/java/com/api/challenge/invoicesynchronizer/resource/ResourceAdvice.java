package com.api.challenge.invoicesynchronizer.resource;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.NoSuchElementException;

@ControllerAdvice
class ResourceAdvice {

    @ExceptionHandler(NoSuchElementException.class)
    public void notFound(final HttpServletResponse response, final NoSuchElementException ex) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }
}
