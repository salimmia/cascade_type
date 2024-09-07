package com.salim.cascadetype.teacher.service.impl;

import com.salim.cascadetype.teacher.domain.Teacher;
import com.salim.cascadetype.teacher.repository.TeacherRepository;
import com.salim.cascadetype.teacher.service.interfaces.TeacherService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Page<Teacher> getTeachers(Pageable pageable) {
        return teacherRepository.findAll(pageable);
    }

    @Override
    public Optional<Teacher> getTeacher(Long id) {
        return teacherRepository.findById(id);
    }

    @Override
    public Teacher updateTeacher(Long id, Teacher teacher) {
        teacherRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
}
