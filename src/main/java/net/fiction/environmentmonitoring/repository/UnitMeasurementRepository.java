package net.fiction.environmentmonitoring.repository;

import net.fiction.environmentmonitoring.model.UnitMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitMeasurementRepository extends JpaRepository<UnitMeasurement, Long> {
}
