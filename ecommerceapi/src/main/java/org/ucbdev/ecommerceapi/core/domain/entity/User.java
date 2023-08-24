package org.ucbdev.ecommerceapi.core.domain.entity;

import jakarta.persistence.*;
import org.ucbdev.ecommerceapi.core.domain.entity.base.BaseEntity;

import java.util.Objects;

@Entity
@Table(name = "Users")
public class User extends BaseEntity {
    @Column(name = "username", length = 50, nullable = false)

    private String username;
    @Column(name = "password", length = 50, nullable = false)

    private String password;
    @Column(name = "email", length = 50, nullable = false, unique = true)

    private String email;
    @Column(name = "phone", length = 20, unique = true)

    private String phone;
    @Column(name = "age", precision = 2)

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return version == user.version && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(phone, user.phone) && Objects.equals(age, user.age) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, email, phone, age, version, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", version=" + version +
                ", role=" + role +
                ", id=" + id +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", deletedDate=" + deletedDate +
                '}';
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
