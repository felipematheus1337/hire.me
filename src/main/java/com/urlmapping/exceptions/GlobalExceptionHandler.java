package com.urlmapping.exceptions;


import com.urlmapping.dtos.ErrorResponseDTO;
import com.urlmapping.dtos.GenericErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(AliasAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDTO> handleAliasAlreadyExists(AliasAlreadyExistsException ex) {
        var errorResponse = new ErrorResponseDTO(
                ex.getCustomAlias(),
                "ALIAS_ALREADY_EXISTS",
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    @ExceptionHandler(URLNotProvidedException.class)
    public ResponseEntity<ErrorResponseDTO> handleURLNotProvided(URLNotProvidedException ex) {
        var errorResponse = new ErrorResponseDTO(ex.getCustomAlias(), "URL_NOT_PROVIDED", ex.getMessage());
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericErrorResponse> handleGenericException(Exception ex) {
        var error = new GenericErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());

        return ResponseEntity.status(error.statusCode()).body(error);
    }
}
