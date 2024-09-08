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

import java.util.List;

@Component
public class StudentMapper {

    private final CourseRepository courseRepository;

    public StudentMapper(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Student toEntity(StudentReqDto studentReqDto){
        List<Course> courses = courseRepository.findAllById(studentReqDto.courseIds());

        return Student.builder()
                .firstName(studentReqDto.firstName())
                .lastName(studentReqDto.lastName())
                .email(studentReqDto.email())
                .dateOfBirth(studentReqDto.dateOfBirth())
                .courses(courses)
                .build();
    }

    public StudentResDto toDto(Student student){

        List<Long> courseIds = student.getCourses().stream()
                .map(BaseEntity::getId)
                .toList();

        return StudentResDto.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .dateOfBirth(student.getDateOfBirth())
                .courseIds(courseIds)
                .build();
    }
}
