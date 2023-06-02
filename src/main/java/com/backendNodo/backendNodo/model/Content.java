package com.backendNodo.backendNodo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "contents")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Content {
    @Id
    @GeneratedValue(generator = "uuid")
    @Column(columnDefinition = "VARCHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @Column
    private String name;

    @OneToMany(mappedBy = "content")
    @JsonIgnore
    private Set<Image> images;

    @OneToMany(mappedBy = "content")
    @JsonIgnore
    private Set<Video> videos;

    @OneToMany(mappedBy = "content")
    @JsonIgnore
    private Set<Pdf> pdfs;

    @OneToMany(mappedBy = "content")
    @JsonIgnore
    private Set<Podcast> podcasts;

    @OneToMany(mappedBy = "content")
    @JsonIgnore
    private Set<Text> texts;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
}
