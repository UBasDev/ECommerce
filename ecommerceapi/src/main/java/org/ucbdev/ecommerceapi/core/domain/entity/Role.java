package org.ucbdev.ecommerceapi.core.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

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
}
