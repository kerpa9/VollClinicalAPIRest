package med.voll.api.config.handleErrors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;
import med.voll.api.config.dto.ManageErrorDTO;
import med.voll.api.config.handleException.ValidateException;

@RestControllerAdvice
public class CatchError {

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity notFound404() {
        return ResponseEntity.notFound().build();


    }

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity batRequest400(MethodArgumentNotValidException e) {

        var errors = e.getFieldErrors().stream().map(ManageErrorDTO::new).toList();
        return ResponseEntity.badRequest().body(errors);

    }

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(ValidateException.class)
    public ResponseEntity manageErrorValidate(ValidateException e) {
        return ResponseEntity.badRequest().body(e.getMessage());

    }



}
