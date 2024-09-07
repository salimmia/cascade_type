package com.salim.cascadetype.author.domain;

import com.salim.cascadetype.base.BaseEntity;
import com.salim.cascadetype.course.domain.Course;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(
                columnNames = "email",
                name = "unique_author_email"
        )
})
public class Author extends BaseEntity {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;
}
