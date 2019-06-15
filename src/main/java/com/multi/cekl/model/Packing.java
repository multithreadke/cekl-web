package com.multi.cekl.model;

import com.multi.cekl.utils.AbstractBaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "PACKING", indexes = @Index(name = "PACKING_INDEX", columnList = "ID"))
public class Packing extends AbstractBaseEntity {

    @Column(name = "NAME", unique = true, length = 5)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    public Packing() {
    }

    public Packing(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Packing{" +
                "id='" + getId() + '\'' +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
