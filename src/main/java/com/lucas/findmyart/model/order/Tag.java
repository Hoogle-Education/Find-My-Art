package com.lucas.findmyart.model.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@Table(name = "tags")
@NoArgsConstructor @RequiredArgsConstructor
public class Tag {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull private String tag;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "tags",
        cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Product> products = new HashSet<>();

}
