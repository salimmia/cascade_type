package com.salim.cascadetype.teacher.service.impl;

import com.salim.cascadetype.base.BaseEntity;
import com.salim.cascadetype.course.domain.Course;
import com.salim.cascadetype.course.repository.CourseRepository;
import com.salim.cascadetype.teacher.domain.Teacher;
import com.salim.cascadetype.teacher.dto.TeacherReqDto;
import com.salim.cascadetype.teacher.dto.TeacherResDto;
import com.salim.cascadetype.teacher.mapper.TeacherMapper;
import com.salim.cascadetype.teacher.repository.TeacherRepository;
import com.salim.cascadetype.teacher.service.interfaces.TeacherService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;
    private final CourseRepository courseRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository, TeacherMapper teacherMapper, CourseRepository courseRepository) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
        this.courseRepository = courseRepository;
    }

    @Override
    public Page<Teacher> getTeachers(Pageable pageable) {
        return teacherRepository.findAll(pageable);
    }

    @Override
    public TeacherResDto getTeacher(Long id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return teacherMapper.toDto(teacher);
    }

    @Override
    public TeacherResDto updateTeacher(Long id, TeacherReqDto teacherReqDto) {
        Teacher dbTeacher = teacherRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        List<Long> courseIds = dbTeacher.getCourses().stream()
                .map(BaseEntity::getId)
                .toList();

        if(!teacherReqDto.firstName().isEmpty() && !Objects.equals(dbTeacher.getFirstName(), teacherReqDto.firstName())) {
            dbTeacher.setFirstName(teacherReqDto.firstName());
        }
        if (!teacherReqDto.lastName().isEmpty() && !Objects.equals(dbTeacher.getLastName(), teacherReqDto.lastName())) {
            dbTeacher.setLastName(teacherReqDto.lastName());
        }
        if (!teacherReqDto.email().isEmpty() && !Objects.equals(dbTeacher.getEmail(), teacherReqDto.email())) {
            dbTeacher.setEmail(teacherReqDto.email());
        }
        if (!teacherReqDto.courseIds().isEmpty() && !Objects.equals(courseIds, teacherReqDto.courseIds())) {
            List<Course> courses = courseRepository.findAllById(teacherReqDto.courseIds());
            dbTeacher.setCourses(courses);
        }

        return teacherMapper.toDto(teacherRepository.save(dbTeacher));
    }

    @Override
    public TeacherResDto createTeacher(TeacherReqDto teacherReqDto) {
        return teacherMapper.toDto(teacherRepository.save(teacherMapper.toEntity(teacherReqDto)));
    }
}
