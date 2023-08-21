package org.ucbdev.ecommerceapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.ucbdev.ecommerceapi.entity.base.BaseEntity;

@Entity
@Table(name = "Users")
public class User extends BaseEntity {
    @Column(name = "username", length = 50, nullable = false)
    @Size(min = 1, max = 50, message = "Username field size is invalid")
    @NotEmpty(
            message= "Username field can't be empty"
    )
    private String username;
    @Column(name = "password", length = 50, nullable = false)
    @Size(min = 1, max = 50, message = "Password field size is invalid")
    @NotEmpty(
            message= "Password field can't be empty"
    )
    private String password;
    @Column(name = "email", length = 50, nullable = false)
    @Email(
            message = "Email is invalid"
    )
    @Size(min = 1, max = 50, message = "Email field size is invalid")
    @NotEmpty(
            message= "Email field can't be empty"
    )
    private String email;
    @Column(name = "phone", length = 20, nullable = true)
    @Size(max = 20, message = "Phone field size is invalid")
    private String phone;
    @Column(name = "age", nullable = true, precision = 2)
    @Min(
            value = 1,
            message = "Age field can't be less than 1"
    )
    @Max(
            value = 127,
            message = "Age field can't be more than 127"
    )
    private Byte age;
    @Version
    private int version;
    @OneToOne(

            mappedBy= "user",

            cascade= CascadeType.ALL,

            fetch = FetchType.LAZY,

            orphanRemoval = true
    )
    private Role role;
}
