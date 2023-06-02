package com.backendNodo.backendNodo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Table(name = "texts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Text {
    @Id
    @GeneratedValue(generator = "uuid")
    @Column(columnDefinition = "VARCHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @Column
    private String description;

    @Column
    private String text;

    @ManyToOne
    @JoinColumn(name = "content_id", referencedColumnName = "id")
    private Content content;
}
