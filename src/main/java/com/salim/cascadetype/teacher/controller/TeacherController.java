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

    @PutMapping("{id}")
    public ResponseEntity<ApiResponse> updateTeacher(@PathVariable("id") Long id, @RequestBody TeacherReqDto teacherReqDto) {
        TeacherResDto updatedTeacherResDto = teacherService.updateTeacher(id, teacherReqDto);

        return ResponseEntity
                .ok()
                .body(ApiResponse.builder()
                        .success(true)
                        .message("Update teacher")
                        .data(updatedTeacherResDto)
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
}
