package io.cncf.community.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class PersonDto {
       
    public String id;
    public String name;
    public String email;
    
    public PersonDto() {
    }

    public PersonDto(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public PersonDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }    
}
