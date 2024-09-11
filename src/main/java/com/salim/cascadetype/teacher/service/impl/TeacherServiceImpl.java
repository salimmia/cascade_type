package com.salim.cascadetype.teacher.service.impl;

import com.salim.cascadetype.course.domain.Course;
import com.salim.cascadetype.course.repository.CourseRepository;
import com.salim.cascadetype.teacher.domain.Teacher;
import com.salim.cascadetype.teacher.dto.TeacherReqDto;
import com.salim.cascadetype.teacher.dto.TeacherResDto;
import com.salim.cascadetype.teacher.mapper.TeacherMapper;
import com.salim.cascadetype.teacher.repository.TeacherRepository;
import com.salim.cascadetype.teacher.service.interfaces.TeacherService;
import com.salim.cascadetype.util.FieldDifferentUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

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
    public Page<TeacherResDto> getTeachers(Pageable pageable) {
        return teacherRepository.findAll(pageable).map(teacherMapper::toDto);
    }

    @Override
    public TeacherResDto getTeacher(Long id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return teacherMapper.toDto(teacher);
    }

    @Override
    public TeacherResDto updateTeacher(Long id, TeacherReqDto teacherReqDto) {
        Teacher dbTeacher = teacherRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        updateIfDifferent(teacherReqDto.firstName(), dbTeacher.getFirstName(), dbTeacher::setFirstName);
        updateIfDifferent(teacherReqDto.lastName(), dbTeacher.getLastName(), dbTeacher::setLastName);
        updateIfDifferent(teacherReqDto.email(), dbTeacher.getEmail(), dbTeacher::setEmail);
        if (!teacherReqDto.courseIds().isEmpty()) {
            Set<Course> courses = new HashSet<>(courseRepository.findAllById(teacherReqDto.courseIds()));
            dbTeacher.setCourses(courses);
        }

        return teacherMapper.toDto(teacherRepository.save(dbTeacher));
    }

    @Override
    public TeacherResDto createTeacher(TeacherReqDto teacherReqDto) {
        return teacherMapper.toDto(teacherRepository.save(teacherMapper.toEntity(teacherReqDto)));
    }

    private <T> void updateIfDifferent(T newValue, T oldValue, Consumer<T> updater){
        if (FieldDifferentUtil.isDifferent(newValue, oldValue)){
            updater.accept(newValue);
        }
    }
}
