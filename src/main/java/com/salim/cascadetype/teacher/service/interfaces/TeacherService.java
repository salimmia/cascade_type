package com.salim.cascadetype.teacher.service.interfaces;

import com.salim.cascadetype.course.domain.Course;
import com.salim.cascadetype.teacher.domain.Teacher;
import com.salim.cascadetype.teacher.dto.TeacherReqDto;
import com.salim.cascadetype.teacher.dto.TeacherResDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TeacherService {
    Page<TeacherResDto> getTeachers(Pageable pageable);
    TeacherResDto getTeacher(Long id);
    TeacherResDto updateTeacher(Long id, TeacherReqDto teacherReqDto);
    TeacherResDto createTeacher(TeacherReqDto teacherReqDto);
}
