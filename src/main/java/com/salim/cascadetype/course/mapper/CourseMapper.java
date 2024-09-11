package com.salim.cascadetype.course.mapper;

import com.salim.cascadetype.author.domain.Author;
import com.salim.cascadetype.author.repository.AuthorRepository;
import com.salim.cascadetype.base.BaseEntity;
import com.salim.cascadetype.course.domain.Course;
import com.salim.cascadetype.course.dto.CourseReqDto;
import com.salim.cascadetype.course.dto.CourseResDto;
import com.salim.cascadetype.student.domain.Student;
import com.salim.cascadetype.student.repository.StudentRepository;
import com.salim.cascadetype.teacher.domain.Teacher;
import com.salim.cascadetype.teacher.repository.TeacherRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;

@Component
public class CourseMapper {

    private final AuthorRepository authorRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    public CourseMapper(
            AuthorRepository authorRepository,
            TeacherRepository teacherRepository,
            StudentRepository studentRepository
    ) {
        this.authorRepository = authorRepository;
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
    }

    public Course toEntity(CourseReqDto courseReqDto){
        return Course.builder()
                .courseName(courseReqDto.courseName())
                .description(courseReqDto.description())
                .author(authorRepository.findById(courseReqDto.authorId()).orElse(null))
                .teachers(new HashSet<>(teacherRepository.findAllById(courseReqDto.teacherIds())))
                .students(new HashSet<>(studentRepository.findAllById(courseReqDto.studentIds())))
                .build();
    }

    public CourseResDto toDto(Course course){
        return CourseResDto.builder()
                .id(course.getId())
                .courseName(course.getCourseName())
                .description(course.getDescription())
                .authorId(course.getId() != null ? course.getAuthor().getId() : null)
                .teacherIds(course.getTeachers().stream().map(BaseEntity::getId).toList())
                .studentIds(course.getStudents().stream().map(BaseEntity::getId).toList())
                .build();
    }
}
