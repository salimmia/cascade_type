package com.salim.cascadetype.student.service.impl;

import com.salim.cascadetype.course.domain.Course;
import com.salim.cascadetype.course.repository.CourseRepository;
import com.salim.cascadetype.student.domain.Student;
import com.salim.cascadetype.student.dto.StudentReqDto;
import com.salim.cascadetype.student.dto.StudentResDto;
import com.salim.cascadetype.student.mapper.StudentMapper;
import com.salim.cascadetype.student.repository.StudentRepository;
import com.salim.cascadetype.student.service.interfaces.StudentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
        return studentMapper.toDto(studentRepository.save(studentMapper.toEntity(studentReqDto)));
    }

    @Override
    public Page<Student> getAllStudents(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public StudentResDto updateStudent(Long id, StudentReqDto studentReqDto) {
        Student student = studentMapper.toEntity(studentReqDto);
        student.setId(id);
        Student dbStudent = studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Student not found"));

        if (studentReqDto.firstName() != null && !Objects.equals(studentReqDto.firstName(), dbStudent.getFirstName())) {
            student.setFirstName(studentReqDto.firstName());
        }
        if (studentReqDto.lastName() != null && !Objects.equals(studentReqDto.lastName(), dbStudent.getLastName())) {
            student.setLastName(studentReqDto.lastName());
        }
        if (studentReqDto.email() != null && !Objects.equals(studentReqDto.email(), dbStudent.getEmail())) {
            student.setEmail(studentReqDto.email());
        }
        if (studentReqDto.dateOfBirth() != null && !Objects.equals(studentReqDto.dateOfBirth(), dbStudent.getDateOfBirth())) {
            student.setDateOfBirth(studentReqDto.dateOfBirth());
        }
        if (studentReqDto.courseIds() != null && !studentReqDto.courseIds().isEmpty()) {
            List<Course> courses = courseRepository.findAllById(studentReqDto.courseIds());
            student.setCourses(courses);
        }

        return studentMapper.toDto(studentRepository.save(student));
    }
}
