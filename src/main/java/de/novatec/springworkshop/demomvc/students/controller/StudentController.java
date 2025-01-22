package de.novatec.springworkshop.demomvc.students.controller;

import de.novatec.springworkshop.demomvc.students.dto.StudentDTO;
import de.novatec.springworkshop.demomvc.students.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/university")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<StudentDTO> findAll(){
        return studentService.findAll();
    }

    @GetMapping("/student/{name}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public StudentDTO findStudentByName(@PathVariable String name) {
        return studentService.find(name);
    }

    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody StudentDTO studentDTO) {
        studentService.save(studentDTO);
    }


}
