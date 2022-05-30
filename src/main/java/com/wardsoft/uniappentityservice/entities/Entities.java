package com.wardsoft.uniappentityservice.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "entities", schema = "entities")
public class Entities {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @OneToOne(optional = false)
    private Entities parent;

    public Object getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getParent() {
        return parent;
    }

    public void setParent(Entities parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entities that = (Entities) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(parent, that.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, parent);
    }
}
