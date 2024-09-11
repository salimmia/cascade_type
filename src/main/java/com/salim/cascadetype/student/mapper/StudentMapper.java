package com.salim.cascadetype.student.mapper;

import com.salim.cascadetype.base.BaseEntity;
import com.salim.cascadetype.course.domain.Course;
import com.salim.cascadetype.course.dto.CourseResDto;
import com.salim.cascadetype.course.mapper.CourseMapper;
import com.salim.cascadetype.course.repository.CourseRepository;
import com.salim.cascadetype.student.domain.Student;
import com.salim.cascadetype.student.dto.StudentReqDto;
import com.salim.cascadetype.student.dto.StudentResDto;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class StudentMapper {

    private final CourseRepository courseRepository;

    public StudentMapper(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Student toEntity(StudentReqDto studentReqDto){
        return Student.builder()
                .firstName(studentReqDto.firstName())
                .lastName(studentReqDto.lastName())
                .email(studentReqDto.email())
                .dateOfBirth(studentReqDto.dateOfBirth())
                .courses(new HashSet<>(courseRepository.findAllById(studentReqDto.courseIds())))
                .build();
    }

    public StudentResDto toDto(Student student){
        return StudentResDto.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .dateOfBirth(student.getDateOfBirth())
                .courseIds(student.getCourses().stream()
                        .map(BaseEntity::getId)
                        .collect(Collectors.toSet()))
                .build();
    }
}
