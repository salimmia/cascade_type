package com.salim.cascadetype.student.service.interfaces;

import com.salim.cascadetype.student.domain.Student;
import com.salim.cascadetype.student.dto.StudentReqDto;
import com.salim.cascadetype.student.dto.StudentResDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    StudentResDto addNewStudent(StudentReqDto studentReqDto);
    Page<Student> getAllStudents(Pageable pageable);
    StudentResDto updateStudent(Long id, StudentReqDto studentReqDto);
}
