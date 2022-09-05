package test.task.gaswater.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class MeasurementDTO implements Serializable {
    private Double meter;
    @NotNull
    private MeasurementType type;
}
