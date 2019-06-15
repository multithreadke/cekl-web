package com.multi.cekl.dto;

import javax.validation.constraints.NotEmpty;

public class PackingDTO {

    @NotEmpty(message = "Name field cannot be empty!")
    private String name;

    @NotEmpty(message = "Description field cannot be empty!")
    private String description;

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
        return "PackingDTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
