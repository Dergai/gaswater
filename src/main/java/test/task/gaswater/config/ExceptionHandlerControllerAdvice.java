package test.task.gaswater.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import test.task.gaswater.controller.ApiController;
import test.task.gaswater.exception.ApiExceptionWrapper;
import test.task.gaswater.exception.ResourceNotFoundException;

@Slf4j
@ControllerAdvice(assignableTypes = {ApiController.class})
public class ExceptionHandlerControllerAdvice {
    @ExceptionHandler({ResourceNotFoundException.class})
    protected ResponseEntity<ApiExceptionWrapper> handleResourceNotFoundException(
            ResourceNotFoundException exception) {
        return new ResponseEntity<>(new ApiExceptionWrapper(exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({IllegalArgumentException.class})
    protected ResponseEntity<ApiExceptionWrapper> handleIllegalArgumentException(
            ResourceNotFoundException exception) {
        return new ResponseEntity<>(new ApiExceptionWrapper(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
