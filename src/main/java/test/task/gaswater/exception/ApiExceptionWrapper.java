package test.task.gaswater.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ApiExceptionWrapper {
    private String errorMessage;

    public ApiExceptionWrapper(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
