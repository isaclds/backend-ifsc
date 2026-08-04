package ifsc.ads.todolist.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrity(DataIntegrityViolationException e, WebRequest request) {
        String message = "Dados inválidos ou relacionados a um registro inexistente.";

        String rawMessage = e.getMostSpecificCause().getMessage();
        if (rawMessage != null) {
            if (rawMessage.contains("FOREIGN KEY") || rawMessage.contains("Referential integrity")) {
                message = "Não foi possível salvar: o registro referenciado (ex: lista, tarefa) não existe.";
            } else if (rawMessage.contains("UNIQUE") || rawMessage.contains("Unique index")) {
                message = "Já existe um registro com esses dados (violação de unicidade).";
            }
        }

        ErrorResponse error = ErrorResponse.of(
                HttpStatus.BAD_REQUEST.value(),
                "Dados inválidos",
                message,
                path(request)
        );
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(EntityNotFoundException e, WebRequest request) {
        ErrorResponse error = ErrorResponse.of(
                HttpStatus.NOT_FOUND.value(),
                "Não encontrado",
                e.getMessage(),
                path(request)
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(Exception e, WebRequest request) {
        ErrorResponse error = ErrorResponse.of(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Erro interno",
                "Ocorreu um erro inesperado. Tente novamente mais tarde.",
                path(request)
        );
        return ResponseEntity.internalServerError().body(error);
    }

    private String path(WebRequest request) {
        return request.getDescription(false).replace("uri=", "");
    }
}