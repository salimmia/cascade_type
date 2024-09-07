package com.salim.cascadetype.studyCLass.domain;

import com.salim.cascadetype.base.BaseEntity;
import com.salim.cascadetype.section.domain.Section;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class StudyClass extends BaseEntity {

    private String className;

    private String description;

    @OneToMany(mappedBy = "studyClass")
    private Set<Section> sections;
}
