package com.salim.cascadetype.author.domain;

import com.salim.cascadetype.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@Table(uniqueConstraints = {
        @UniqueConstraint(
                columnNames = "email",
                name = "unique_author_email"
        )
})
@AllArgsConstructor
public class Author extends BaseEntity {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    public Author() {

    }
}
