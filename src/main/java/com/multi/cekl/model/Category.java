package com.multi.cekl.model;

import com.multi.cekl.utils.AbstractBaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORY", indexes = @Index(name = "CATEGORY_INDEX", columnList = "ID, NAME"))
public class Category extends AbstractBaseEntity {

    @Column(name = "NAME", unique = true, length = 30)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    public Category() {
    }

    public Category(String name, String description) {
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
        return "Category{" +
                "id='" + getId() + '\'' +
                "name='" +name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
