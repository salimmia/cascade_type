package com.salim.cascadetype.section.domain;

import com.salim.cascadetype.base.BaseEntity;
import com.salim.cascadetype.studyCLass.domain.StudyClass;
import com.salim.cascadetype.teacher.domain.Teacher;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Section extends BaseEntity {

    private String sectionName;

    @ManyToOne
    private StudyClass studyClass;
}
