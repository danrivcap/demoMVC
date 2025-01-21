package de.novatec.springworkshop.demomvc.students.service;

import de.novatec.springworkshop.demomvc.students.mapper.StudentMapper;
import de.novatec.springworkshop.demomvc.students.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.novatec.springworkshop.demomvc.students.dto.StudentDTO;

import java.time.Instant;
import java.util.List;
import java.util.stream.StreamSupport;


@Service
public class StudentService {

    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Transactional(readOnly = true)
    public List<StudentDTO> findAll() {
        return StreamSupport.stream(studentRepository.findAll().spliterator(), false).map(studentMapper::toDto).toList();
    }

    @Transactional(readOnly = true)
    public StudentDTO find(String name){
        return studentMapper.toDto(studentRepository.findByName(name));
    }

    @Transactional
    public void save(StudentDTO studentDTO) {
        var student = studentMapper.toEntity(studentDTO);
        student.setCreatedAt(Instant.now());
        studentRepository.save(student);
    }

}
