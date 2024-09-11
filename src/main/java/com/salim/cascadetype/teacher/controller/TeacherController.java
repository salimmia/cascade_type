package com.salim.cascadetype.teacher.controller;

import com.salim.cascadetype.exception.ApiResponse;
import com.salim.cascadetype.teacher.domain.Teacher;
import com.salim.cascadetype.teacher.dto.TeacherReqDto;
import com.salim.cascadetype.teacher.dto.TeacherResDto;
import com.salim.cascadetype.teacher.service.interfaces.TeacherService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/teacher/")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllTeachers(Pageable pageable) {
        return ResponseEntity
                .ok()
                .body(ApiResponse.builder()
                        .success(true)
                        .message("Find all teachers")
                        .data(teacherService.getTeachers(pageable))
                        .build());
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse> getTeacher(@PathVariable("id") Long id) {
        return ResponseEntity
                .ok()
                .body(ApiResponse.builder()
                        .success(true)
                        .message("Find teacher by id" + id)
                        .data(teacherService.getTeacher(id))
                        .build());
    }

    @PutMapping("{id}")
    public ResponseEntity<ApiResponse> updateTeacher(@PathVariable("id") Long id, @RequestBody TeacherReqDto teacherReqDto) {
        return ResponseEntity
                .ok()
                .body(ApiResponse.builder()
                        .success(true)
                        .message("Update teacher")
                        .data(teacherService.updateTeacher(id, teacherReqDto))
                        .build());
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createTeacher(@RequestBody TeacherReqDto teacherReqDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.builder()
                        .success(true)
                        .message("Create teacher")
                        .data(teacherService.createTeacher(teacherReqDto))
                        .build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse> deleteTeacher(@PathVariable("id") Long id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity
                .ok()
                .body(ApiResponse.builder()
                        .success(true)
                        .message("Delete teacher successfully of id: " + id)
                        .data(null)
                        .build());
    }
}
