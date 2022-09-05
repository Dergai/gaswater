package test.task.gaswater.model.entity;

import lombok.*;
import test.task.gaswater.model.MeasurementType;

import javax.persistence.*;

@Entity
@Data
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Person person;
    private Double meter;
    @Enumerated(EnumType.STRING)
    private MeasurementType type;
}
