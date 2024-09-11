package com.salim.cascadetype.student.service.impl;

import com.salim.cascadetype.course.domain.Course;
import com.salim.cascadetype.course.repository.CourseRepository;
import com.salim.cascadetype.student.domain.Student;
import com.salim.cascadetype.student.dto.StudentReqDto;
import com.salim.cascadetype.student.dto.StudentResDto;
import com.salim.cascadetype.student.mapper.StudentMapper;
import com.salim.cascadetype.student.repository.StudentRepository;
import com.salim.cascadetype.student.service.interfaces.StudentService;
import com.salim.cascadetype.util.FieldDifferentUtil;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final CourseRepository courseRepository;

    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.courseRepository = courseRepository;
    }

    @Override
    public StudentResDto addNewStudent(StudentReqDto studentReqDto) {
        Set<Course> courses = new HashSet<>(courseRepository.findAllById(studentReqDto.courseIds()));
        if (courses.size() != studentReqDto.courseIds().size()) {
            throw new EntityNotFoundException("Some courses not found");
        }
        return studentMapper.toDto(studentRepository.save(studentMapper.toEntity(studentReqDto)));
    }

    @Override
    public Page<StudentResDto> getAllStudents(Pageable pageable) {
        return studentRepository.findAll(pageable)
                .map(studentMapper::toDto);
    }

    @Transactional
    @Override
    public StudentResDto updateStudent(Long id, StudentReqDto studentReqDto) {
        Student dbStudent = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));

        updateIfDifferent(studentReqDto.firstName(), dbStudent.getFirstName(), dbStudent::setFirstName);
        updateIfDifferent(studentReqDto.lastName(), dbStudent.getLastName(), dbStudent::setLastName);
        updateIfDifferent(studentReqDto.email(), dbStudent.getEmail(), dbStudent::setEmail);
        updateIfDifferent(studentReqDto.dateOfBirth(), dbStudent.getDateOfBirth(), dbStudent::setDateOfBirth);

        if (studentReqDto.courseIds() != null && !studentReqDto.courseIds().isEmpty()) {
            Set<Course> courses = new HashSet<>(courseRepository.findAllById(studentReqDto.courseIds()));
            dbStudent.setCourses(courses);
        }

        return studentMapper.toDto(studentRepository.save(dbStudent));
    }

    @Override
    public StudentResDto getStudent(Long id) {
        return studentMapper.toDto(studentRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Student not found " + id)));
    }

    @Transactional
    @Override
    public void deleteStudent(Long id) {
        Student dbStudent = studentRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("Student not found " + id));
        new HashSet<>(dbStudent.getCourses()).forEach(dbStudent::removeCourse);

        studentRepository.delete(dbStudent);
    }

    private <T> void updateIfDifferent(T newValue, T oldValue, Consumer<T> updater) {
        if (FieldDifferentUtil.isDifferent(newValue, oldValue)) {
            updater.accept(newValue);
        }
    }
}
