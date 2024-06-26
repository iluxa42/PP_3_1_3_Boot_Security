package ru.kata.spring.boot_security.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    public Role(String name) {
        this.name = name;
    }

    public String getNameWithoutPrefix() {
        return name.substring(5);
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
