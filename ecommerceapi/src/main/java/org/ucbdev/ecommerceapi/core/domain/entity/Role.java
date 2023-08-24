package org.ucbdev.ecommerceapi.core.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "Roles")
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, length = 30)
    @Size(min = 1, max = 30, message = "Name field size is invalid")
    @NotEmpty(
            message= "Name field can't be empty"
    )
    private String name;
    @Column(name = "value", nullable = false, length = 50)
    @Size(min = 1, max = 50, message = "Value field size is invalid")
    @NotEmpty(
            message= "Value field can't be empty"
    )
    private String value;
    @Column(name = "code", nullable = false, precision = 2)
    @Min(
            value = 1,
            message = "Code field can't be less than 1"
    )
    @Max(
            value = 127,
            message = "Code field can't be more than 127"
    )
    private Byte code;
    @CreationTimestamp
    private LocalDateTime createdDate;
    @UpdateTimestamp
    private LocalDateTime updatedDate;
    @Version
    private int version;
    @OneToOne
    @JoinColumn(
            name= "user_id",

            updatable= true,

            nullable= false,

            unique= true,

            insertable= true
    )
    private User user;
    public Role(){

    }

    public Role(String name, String value, Byte code) {
        this.name = name;
        this.value = value;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Byte getCode() {
        return code;
    }

    public void setCode(Byte code) {
        this.code = code;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public int getVersion() {
        return version;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        if(!this.user.equals(user)){
            this.user = user;
            user.setRole(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role role)) return false;
        return version == role.version && Objects.equals(id, role.id) && Objects.equals(name, role.name) && Objects.equals(value, role.value) && Objects.equals(code, role.code) && Objects.equals(createdDate, role.createdDate) && Objects.equals(updatedDate, role.updatedDate) && Objects.equals(user, role.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, value, code, createdDate, updatedDate, version, user);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", code=" + code +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", version=" + version +
                ", user=" + user +
                '}';
    }

    public static RoleBuilder startBuild(){
        return new RoleBuilder();
    }
    public static class RoleBuilder{
        private String name;
        private String value;
        private Byte code;
        public RoleBuilder setName(String name){
            this.name = name;
            return this;
        }
        public RoleBuilder setValue(String value){
            this.value = value;
            return this;
        }
        public RoleBuilder setCode(Byte code){
            this.code = code;
            return this;
        }
        public Role buildEnd(){
            return new Role(this.name, this.value, this.code);
        }
    }
}
