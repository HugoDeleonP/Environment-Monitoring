package net.fiction.environmentmonitoring.repository;

import net.fiction.environmentmonitoring.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
}
