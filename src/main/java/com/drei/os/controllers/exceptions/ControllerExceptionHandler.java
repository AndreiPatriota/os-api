package com.drei.os.controllers.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.drei.os.services.exceptions.DataViolationIntegrityException;
import com.drei.os.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {

        @ExceptionHandler(ObjectNotFoundException.class)
        public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e) {

                var error = new StandardError(System.currentTimeMillis(),
                                HttpStatus.NOT_FOUND.value(),
                                e.getMessage());

                return ResponseEntity
                                .status(HttpStatus.NOT_FOUND)
                                .body(error);
        }

        @ExceptionHandler(DataViolationIntegrityException.class)
        public ResponseEntity<StandardError> dataViolationIntegrityException(DataViolationIntegrityException e) {
                var error = new StandardError(System.currentTimeMillis(),
                                HttpStatus.NOT_FOUND.value(),
                                e.getMessage());

                return ResponseEntity
                                .status(HttpStatus.BAD_REQUEST)
                                .body(error);
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<StandardError> methodArgumentNotValidException(MethodArgumentNotValidException e) {
                var error = new ValidationError(System.currentTimeMillis(),
                                HttpStatus.NOT_FOUND.value(),
                                "Erro na validação dos campos!");

                e.getBindingResult()
                                .getFieldErrors()
                                .stream()
                                .forEach((x) -> error.setErros(x.getField(), x.getDefaultMessage()));

                return ResponseEntity
                                .status(HttpStatus.BAD_REQUEST)
                                .body(error);
        }

        @ExceptionHandler(DataIntegrityViolationException.class)
        public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException e) {
                var error = new StandardError(System.currentTimeMillis(),
                                HttpStatus.BAD_REQUEST.value(),
                                e.getMessage());

                return ResponseEntity
                                .status(HttpStatus.BAD_REQUEST)
                                .body(error);
        }

}
