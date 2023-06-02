package com.backendNodo.backendNodo.model;

import com.backendNodo.backendNodo.model.enums.RolUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(generator = "uuid")
    @Column(columnDefinition = "VARCHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    private RolUser rolUser = RolUser.USER;

}
