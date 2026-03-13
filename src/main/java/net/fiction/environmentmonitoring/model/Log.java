package net.fiction.environmentmonitoring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "log")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Log {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Double value;

    @Column(name="date_hour", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime dateHour;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private UnitMeasurement unitMeasurement;

    public Log(Double value, LocalDateTime dateHour, Room room, UnitMeasurement unitMeasurement) {
        this.value = value;
        this.dateHour = dateHour;
        this.room = room;
        this.unitMeasurement = unitMeasurement;
    }

    public Log(Double value, Room room, UnitMeasurement unitMeasurement) {
        this.value = value;
        this.room = room;
        this.unitMeasurement = unitMeasurement;
    }
}
