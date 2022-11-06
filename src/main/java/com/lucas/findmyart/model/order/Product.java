package com.lucas.findmyart.model.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "products")
@Getter @Setter @NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private BigDecimal price;
    private String imgURL;

    @OneToMany(mappedBy = "id.product")
    private Set<OrderItem> items = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "product_tags",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private Set<Tag> tags = new HashSet<>();

    private void addTag(Tag tag) {
        tags.add(tag);
        tag.getProducts().add(this);
    }

    private void removeTag(String tagName) {
        Optional<Tag> tag = this.tags
                .stream()
                .filter(t -> t.getTag().equalsIgnoreCase(tagName))
                .findFirst();

        if(tag.isPresent()) {
            this.tags.remove(tag.get());
            tag.get().getProducts().remove(this);
        }
    }

}
