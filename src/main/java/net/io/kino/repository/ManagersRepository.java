package net.io.kino.repository;

import net.io.kino.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagersRepository extends JpaRepository<User, Long> {
}
