package org.ucbdev.ecommerceapi.core.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.ucbdev.ecommerceapi.core.domain.entity.base.BaseEntity;

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
    @Column(name = "phone", length = 20)
    @Size(max = 20, message = "Phone field size is invalid")
    private String phone;
    @Column(name = "age", precision = 2)
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
    public User(){

    }

    public User(String username, String password, String email, String phone, Byte age) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.age = age;
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

    public int getVersion() {
        return version;
    }
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        if(!this.role.equals(role)){
            this.role = role;
            role.setUser(this);
        }
    }

    public static UserBuilder buildStart(){
        return new UserBuilder();
    }
    public static class UserBuilder{
        private String username;
        private String password;
        private String email;
        private String phone;
        private Byte age;
        public UserBuilder setUsername(String username){
            this.username = username;
            return this;
        }
        public UserBuilder setPassword(String password){
            this.password = password;
            return this;
        }
        public UserBuilder setEmail(String email){
            this.email = email;
            return this;
        }
        public UserBuilder setPhone(String phone){
            this.phone = phone;
            return this;
        }
        public UserBuilder setAge(Byte age){
            this.age = age;
            return this;
        }
        public User buildEnd(){
            return new User(this.username, this.password, this.email, this.phone, this.age);
        }
    }
}
