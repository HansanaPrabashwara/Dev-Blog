package io.crud.crud.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    public String id;
    public String name;
    public String email;
    public String password;
}
