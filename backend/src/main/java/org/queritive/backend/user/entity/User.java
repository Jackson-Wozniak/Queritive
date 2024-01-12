package org.queritive.backend.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "user")
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    private String username;

    @Column(name = "password")
    private String password;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
}
