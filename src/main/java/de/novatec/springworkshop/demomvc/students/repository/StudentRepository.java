package de.novatec.springworkshop.demomvc.students.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.novatec.springworkshop.demomvc.students.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    Student findByName(String name);
}
