package net.fiction.environmentmonitoring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "unit_measurement")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UnitMeasurement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name_magnitude", nullable = false)
    private String nameMagnitude;

    @Column(name = "name_unit", nullable = false)
    private String nameUnit;

    public UnitMeasurement(String nameMagnitude, String nameUnit) {
        this.nameMagnitude = nameMagnitude;
        this.nameUnit = nameUnit;
    }
}
