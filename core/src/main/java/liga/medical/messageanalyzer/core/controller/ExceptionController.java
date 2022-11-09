package liga.medical.messageanalyzer.core.controller;

import liga.medical.commonmodule.dto.body.ResponseBody;
import liga.medical.messageanalyzer.core.exception.RabbitTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(RabbitTypeException.class)
    public ResponseEntity<ResponseBody> handleRabbitTypeException(RabbitTypeException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseBody(
                HttpStatus.BAD_REQUEST.toString(),
                exception.getMessage()
        ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseBody> handleEmptyRabbitDtoField(MethodArgumentNotValidException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseBody(
                HttpStatus.BAD_REQUEST.toString(),
                exception.getBindingResult().getFieldError().getDefaultMessage()
        ));
    }

}
