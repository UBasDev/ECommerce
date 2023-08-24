package org.ucbdev.ecommerceapi.core.application.request.user;

import jakarta.validation.constraints.*;

public class CreateSingleUserRequest {
    @NotEmpty(
            message= "Username field can't be empty"
    )
    @Size(min = 1, max = 50, message = "Username field size is invalid")
    private String username;
    @Size(min = 1, max = 50, message = "Password field size is invalid")
    @NotEmpty(
            message= "Password field can't be empty"
    )
    private String password;
    @Email(
            message = "Email is invalid"
    )
    @Size(min = 1, max = 50, message = "Email field size is invalid")
    @NotEmpty(
            message= "Email field can't be empty"
    )
    private String email;
    @Size(max = 20, message = "Phone field size is invalid")
    private String phone;
    @Min(
            value = 1,
            message = "Age field can't be less than 1"
    )
    @Max(
            value = 127,
            message = "Age field can't be more than 127"
    )
    private Byte age;
    @NotEmpty(
            message= "RoleId field can't be empty"
    )
    @Min(
            value = 1,
            message = "RoleId field can't be less than 1"
    )
    private Long roleId;
    public CreateSingleUserRequest(){

    }

    public CreateSingleUserRequest(String username, String password, String email, String phone, Byte age, Long roleId) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.roleId = roleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

}
