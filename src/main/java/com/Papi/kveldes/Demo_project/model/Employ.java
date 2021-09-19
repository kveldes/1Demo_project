package com.Papi.kveldes.Demo_project.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Employ {

    private  UUID id;
    private final Integer age;
    private final String firstName;
    private final String lastName;

    public Employ(
            @JsonProperty ("id") UUID id,
            @JsonProperty ("age")Integer age,
            @JsonProperty ("firstName")String firstName,
            @JsonProperty ("lastName")String lastName) {
        this.id = id;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
