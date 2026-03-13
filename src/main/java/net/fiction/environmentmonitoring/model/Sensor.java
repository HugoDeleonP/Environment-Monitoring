package net.fiction.environmentmonitoring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sensor")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String manufacturer;

    @Column(name = "supply_voltage", nullable = false)
    private Double supplyVoltage;

    public Sensor(String model, String manufacturer, Double supplyVoltage) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.supplyVoltage = supplyVoltage;
    }
}
