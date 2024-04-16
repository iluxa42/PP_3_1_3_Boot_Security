package ru.kata.spring.boot_security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
