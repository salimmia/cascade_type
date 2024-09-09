package com.salim.cascadetype.course.service.impl;

import com.salim.cascadetype.author.domain.Author;
import com.salim.cascadetype.author.repository.AuthorRepository;
import com.salim.cascadetype.course.domain.Course;
import com.salim.cascadetype.course.dto.CourseReqDto;
import com.salim.cascadetype.course.dto.CourseResDto;
import com.salim.cascadetype.course.mapper.CourseMapper;
import com.salim.cascadetype.course.repository.CourseRepository;
import com.salim.cascadetype.course.service.interfaces.CourseService;
import com.salim.cascadetype.student.domain.Student;
import com.salim.cascadetype.student.repository.StudentRepository;
import com.salim.cascadetype.teacher.domain.Teacher;
import com.salim.cascadetype.teacher.repository.TeacherRepository;
import com.salim.cascadetype.util.FieldDifferentUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final AuthorRepository authorRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    public CourseServiceImpl(CourseRepository courseRepository, CourseMapper courseMapper, AuthorRepository authorRepository, TeacherRepository teacherRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
        this.authorRepository = authorRepository;
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public Page<CourseResDto> getCourses(Pageable pageable) {

        return courseRepository.findAll(pageable)
                .map(courseMapper::toDto);
    }

    @Override
    public Optional<CourseResDto> addNewCourse(CourseReqDto courseReqDto) {
        Course course = courseMapper.toEntity(courseReqDto);
        return Optional.of(courseMapper.toDto(courseRepository.save(course)));
    }

    @Override
    public Optional<CourseResDto> getCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return Optional.ofNullable(courseMapper.toDto(course));
    }

    @Override
    public Optional<CourseResDto> updateCourse(Long id, CourseReqDto courseReqDto) {
        Course dbCourse = courseRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        FieldDifferentUtil.updateIfDifferent(courseReqDto.courseName(), dbCourse.getCourseName(), dbCourse::setCourseName);
        FieldDifferentUtil.updateIfDifferent(courseReqDto.description(), dbCourse.getDescription(), dbCourse::setDescription);
        if (courseReqDto.authorId() != null) {
            Author author = authorRepository.findById(courseReqDto.authorId()).orElseThrow(EntityNotFoundException::new);
            dbCourse.setAuthor(author);
        }
        if (courseReqDto.teacherIds() != null) {
            List<Teacher> teachers = teacherRepository.findAllById(courseReqDto.teacherIds());
            if (teachers.size() != courseReqDto.teacherIds().size()) {
                throw new EntityNotFoundException("Some teachers not found");
            }
            dbCourse.setTeachers(teachers);
        }
        if (courseReqDto.studentIds() != null) {
            List<Student> students = studentRepository.findAllById(courseReqDto.studentIds());
            if (students.size() != courseReqDto.studentIds().size()){
                throw new EntityNotFoundException("Some students not found");
            }
            dbCourse.setStudents(students);
        }
        Course updateCourse = courseRepository.save(dbCourse);

        return Optional.of(courseMapper.toDto(updateCourse));
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        courseRepository.deleteById(id);
    }
}
