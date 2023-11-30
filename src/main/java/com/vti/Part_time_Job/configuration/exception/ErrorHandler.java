package com.vti.Part_time_Job.configuration.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.*;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.FileHandler;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler
        implements AuthenticationEntryPoint, AccessDeniedHandler {

    @Autowired
    private MessageSource messageSource;

    private String getMessage(String code, Object... args) {
        return messageSource.getMessage(
                code, args, "Internal Server Error",
                LocaleContextHolder.getLocale());
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleExceptionInternal(Exception exception) {
        String message = getMessage("Exception.message");
        String detailMessage = exception.getLocalizedMessage();
        ErrorResponse response = new ErrorResponse(1, message, detailMessage);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(
            NoHandlerFoundException exception, HttpHeaders headers,
            HttpStatusCode status, WebRequest request) {
        String message = getMessage(
                "NoHandlerFoundException.message ",
                exception.getHttpMethod(),
                exception.getRequestURL()
        );
        String detailMessage = exception.getLocalizedMessage();
        ErrorResponse response = new ErrorResponse(2, message, detailMessage);
        return new ResponseEntity<>(response, headers, status);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException exception, HttpHeaders headers,
            HttpStatusCode status, WebRequest request) {
        String message = "not supported ";
        String detailMessage = exception.getLocalizedMessage();
        ErrorResponse response = new ErrorResponse(3, message, detailMessage);
        return new ResponseEntity<>(response, headers, status);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(
            HttpMediaTypeNotSupportedException exception, HttpHeaders headers,
            HttpStatusCode status, WebRequest request) {
        String message = "not supported ";
        String detailMessage = exception.getLocalizedMessage();
        ErrorResponse response = new ErrorResponse(4, message, detailMessage);
        return new ResponseEntity<>(response, headers, status);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exception, HttpHeaders headers,
            HttpStatusCode status, WebRequest request) {
//        String mesage = getMessage("MethodArgumentNotValidException.message") ;
        String message = "Data is invalid";
        String detailMessage = exception.getLocalizedMessage();
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : exception.getFieldErrors()) {
            String key = error.getField();
            String value = error.getDefaultMessage();
            errors.put(key, value);
        }
        ErrorResponse response = new ErrorResponse(5, message, detailMessage, errors);
        return new ResponseEntity<>(response, headers, status);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<Object> handleConstraintViolation(
            ConstraintViolationException exception) {
        String message = "No handleConstraintViolation  ";
        String detailMessage = exception.getLocalizedMessage();
        Map<String, String> errors = new HashMap<>();
        for (ConstraintViolation<?> violation : exception.getConstraintViolations()) {
            String key = violation.getPropertyPath().toString();
            String value = violation.getMessage();
            errors.put(key, value);
        }
        ErrorResponse response = new ErrorResponse(6, message, detailMessage, errors);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException exception, HttpHeaders headers,
            HttpStatusCode status, WebRequest request) {
        if (exception instanceof MissingServletRequestParameterException) {
            String message = getMessage(
                    "MissingServletRequestParameterException.message",
                    exception.getParameterName(),
                    exception.getParameterType()
            );
            String detailMessage = exception.getLocalizedMessage();
            ErrorResponse response = new ErrorResponse(7, message, detailMessage);
            return new ResponseEntity<>(response, headers, status);
        }
        return super.handleMissingServletRequestParameter(exception, headers, status, request);
    }


    @Override
    protected ResponseEntity<Object> handleTypeMismatch(
            TypeMismatchException exception, HttpHeaders headers,
            HttpStatusCode status, WebRequest request) {
        if (exception instanceof MethodArgumentTypeMismatchException) {
            MethodArgumentTypeMismatchException e = (MethodArgumentTypeMismatchException) exception;
            Class<?> returnType = e.getRequiredType();
            String message = getMessage(
                    "MethodArgumentNotValidException.message",
                    e.getName(),
                    returnType == null ? "null" : returnType.getName()
            );
            String detailMessage = exception.getLocalizedMessage();
            ErrorResponse response = new ErrorResponse(8, message, detailMessage);
            return new ResponseEntity<>(response, headers, status);
        }
        return super.handleTypeMismatch(exception, headers, status, request);
    }

    @Override
    public void commence(
            HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {
        String message = getMessage("AuthenticationException.message");
        String detailMessage = authException.getLocalizedMessage();
        ErrorResponse error = new ErrorResponse(9, message, detailMessage);
        ObjectWriter writer = new ObjectMapper().writerWithDefaultPrettyPrinter();
        String output = writer.writeValueAsString(error);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(output);
    }

    @Override
    public void handle(
            HttpServletRequest request, HttpServletResponse response,
            AccessDeniedException accessDeniedException) throws IOException, ServletException {
        String message = getMessage("AccessDeniedException.message");
        String detailMessage = accessDeniedException.getLocalizedMessage();
        ErrorResponse error = new ErrorResponse(10, message, detailMessage);
        ObjectWriter writer = new ObjectMapper().writerWithDefaultPrettyPrinter();
        String output = writer.writeValueAsString(error);
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(output);
    }
}
