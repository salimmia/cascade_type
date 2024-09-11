package com.salim.cascadetype.teacher.mapper;

import com.salim.cascadetype.base.BaseEntity;
import com.salim.cascadetype.course.domain.Course;
import com.salim.cascadetype.course.repository.CourseRepository;
import com.salim.cascadetype.teacher.domain.Teacher;
import com.salim.cascadetype.teacher.dto.TeacherReqDto;
import com.salim.cascadetype.teacher.dto.TeacherResDto;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TeacherMapper {

    private final CourseRepository courseRepository;

    public TeacherMapper(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Teacher toEntity(TeacherReqDto teacherReqDto) {
//        List<Course> courses = courseRepository.findAllById(teacherReqDto.courseIds());
        Set<Course> courses = new HashSet<>(courseRepository.findAllById(teacherReqDto.courseIds()));
        return Teacher.builder()
                .firstName(teacherReqDto.firstName())
                .lastName(teacherReqDto.lastName())
                .email(teacherReqDto.email())
                .courses(courses)
                .build();
    }

    public TeacherResDto toDto(Teacher teacher) {
        List<Long> courseIds = teacher.getCourses().stream()
                .map(BaseEntity::getId)
                .toList();

        return TeacherResDto.builder()
                .id(teacher.getId())
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .email(teacher.getEmail())
                .courseIds(courseIds)
                .build();
    }
}
