package com.salim.cascadetype.mainTask;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance
@DiscriminatorColumn(name = "type")
public abstract class AllowedType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;
}
