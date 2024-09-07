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
        Author author = authorRepository.findById(courseReqDto.authorId()).orElse(null);
        List<Teacher> teachers = teacherRepository.findAllById(courseReqDto.teacherIds());
        List<Student> students = studentRepository.findAllById(courseReqDto.studentIds());

        return Course.builder()
                .courseName(courseReqDto.courseName())
                .description(courseReqDto.description())
                .author(author)
                .teachers(teachers)
                .students(students)
                .build();
    }

    public CourseResDto toDto(Course course){

        Long authorId = course.getId() != null ? course.getAuthor().getId() : null;
        List<Long> teacherIds = course.getTeachers().stream()
                .map(BaseEntity::getId)
                .sorted()
                .toList();
        List<Long> studentIds = course.getStudents().stream()
                .map(BaseEntity::getId)
                .sorted()
                .toList();

        return CourseResDto.builder()
                .courseName(course.getCourseName())
                .description(course.getDescription())
                .authorId(authorId)
                .teacherIds(teacherIds)
                .studentIds(studentIds)
                .build();
    }
}
