package com.salim.cascadetype.student.controller;

import com.salim.cascadetype.exception.ApiResponse;
import com.salim.cascadetype.student.domain.Student;
import com.salim.cascadetype.student.dto.StudentReqDto;
import com.salim.cascadetype.student.dto.StudentResDto;
import com.salim.cascadetype.student.service.interfaces.StudentService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student/")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createStudent(@RequestBody StudentReqDto studentReqDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.builder()
                        .success(true)
                        .message("Student created")
                        .data(studentService.addNewStudent(studentReqDto))
                        .build());
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getStudents(Pageable pageable) {
        return ResponseEntity
                .ok()
                .body(ApiResponse.builder()
                        .success(true)
                        .message("All students")
                        .data(studentService.getAllStudents(pageable))
                        .build());
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse> getStudent(@PathVariable Long id) {
        return ResponseEntity
                .ok()
                .body(ApiResponse.builder()
                        .success(true)
                        .message("Get Student by id " + id)
                        .data(studentService.getStudent(id))
                        .build());
    }

    @PutMapping("{id}")
    public ResponseEntity<ApiResponse> updateStudent(@PathVariable Long id, @RequestBody StudentReqDto studentReqDto) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.builder()
                        .success(true)
                        .message("Student updated")
                        .data(studentService.updateStudent(id, studentReqDto))
                        .build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity
                .ok()
                .body(ApiResponse.builder()
                        .success(true)
                        .message("Student deleted of id: " + id)
                        .data(null)
                        .build());
    }
}
