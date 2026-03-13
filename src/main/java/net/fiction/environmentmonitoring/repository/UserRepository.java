package net.fiction.environmentmonitoring.repository;

import net.fiction.environmentmonitoring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
