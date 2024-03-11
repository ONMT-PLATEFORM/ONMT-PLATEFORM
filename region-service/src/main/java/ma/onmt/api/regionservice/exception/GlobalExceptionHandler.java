package ma.onmt.api.regionservice.exception;


import ma.onmt.api.regionservice.exception.business.*;
import ma.onmt.api.regionservice.exception.response.ErrorResponse;
import ma.onmt.api.regionservice.exception.*;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
            Exception.class, UserNotFoundException.class, AlreadyExistsException.class, OutOfTimeExpection.class
    })
    public ResponseEntity<Object> globalExceptionHandler(Exception ex) {
        ErrorResponse errorRes = new ErrorResponse("_", HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return ResponseEntity.badRequest().body(errorRes);
    }

    @ExceptionHandler({
            NotFoundException.class,
    })
    public ResponseEntity<Object> notFoundException(NotFoundException ex) {
        ErrorResponse errorRes = new ErrorResponse("404", HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorRes);
    }


//    @ExceptionHandler({
//
//            org.springframework.security.access.AccessDeniedException.class
//    })
//    public ResponseEntity<Object> accessDeniedException(
//            org.springframework.security.access.AccessDeniedException ex
//
//    ) {
//        ErrorResponse errorRes = new ErrorResponse("403", HttpStatus.FORBIDDEN, ex.getMessage());
//        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorRes);
//    }

    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity<ErrorResponse> globalExceptionHandler(NullPointerException ex) {
        ErrorResponse errorRes = new ErrorResponse("400", HttpStatus.BAD_REQUEST, ex.getMessage());
        return ResponseEntity.badRequest().body(errorRes);
    }

    @ExceptionHandler({
            BadRequestException.class,
    })
    public ResponseEntity<ErrorResponse> badRequestException(BadRequestException exception) {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setDetails(exception.getDetails());
        errorResponse.setHorodatage(LocalDateTime.now());
        errorResponse.setCode("400");
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
        return ResponseEntity.badRequest().body(errorResponse);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode("400");
        errorResponse.setMessage("Input validation exception's");
        Map<String, String> map = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String key = error.getObjectName();
            String message = error.getDefaultMessage();
            map.put(key, message);
        });
        errorResponse.setDetails(map);
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return super.handleNoHandlerFoundException(ex, headers, status, request);
    }

//    @ExceptionHandler({
//            MethodArgumentNotValidException.class
//    })
//    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
//        ErrorResponse errorResponse = new ErrorResponse();
//        Map<String, String> map = new HashMap<>();
//
//        ex.getBindingResult().getAllErrors().forEach(error -> {
//            String key = error.getObjectName();
//            String message = error.getDefaultMessage();
//            map.put(key, message);
//        });
//
//        // Remove the following line since it doesn't do anything in your code
//        // ex.getDetailMessageArguments();
//
//        errorResponse.setDetails(map);
//        return ResponseEntity.badRequest().body(errorResponse);
//    }


    @ExceptionHandler({
            IllegalArgumentException.class
    })
    public ResponseEntity<Object> illegalArgumentException(IllegalArgumentException ex) {
        ErrorResponse errorRes = new ErrorResponse("400", HttpStatus.BAD_REQUEST, ex.getMessage());
        return ResponseEntity.badRequest().body(errorRes);
    }

    @ExceptionHandler({DateTimeParseException.class})
    public ResponseEntity<Object> dateTimeParseException(ObjectNotFoundException ex) {
        ErrorResponse errorRes = new ErrorResponse("404", HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.badRequest().body(errorRes);
    }

    @ExceptionHandler({ObjectNotFoundException.class})
    public ResponseEntity<Object> objectNotFoundException(ObjectNotFoundException ex) {
        ErrorResponse errorRes = new ErrorResponse("404", HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorRes);
    }


    private ResponseEntity<Object> buildResponseEntity(ErrorResponse errorRes) {
        HttpStatus status = HttpStatus.valueOf(errorRes.getStatus());
        return new ResponseEntity<>(errorRes, status);
    }
}
