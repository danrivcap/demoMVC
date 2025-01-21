package de.novatec.springworkshop.demomvc.students.mapper;

import de.novatec.springworkshop.demomvc.students.dto.StudentDTO;
import org.springframework.stereotype.Component;
import de.novatec.springworkshop.demomvc.students.entity.Student;

@Component
public class StudentMapper
{
    public StudentDTO toDto( Student student){
        var dto = new StudentDTO();
        dto.setName(student.getName());
        dto.setAge(student.getAge());
        return dto;
    }

    public Student toEntity(StudentDTO student){
        var entity = new Student();
        entity.setName(student.getName());
        entity.setAge(student.getAge());
        return entity;
    }
}
