package com.StudentCrud.Students.Controller;

import com.StudentCrud.Students.Entity.Student;
import com.StudentCrud.Students.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("saveStuds")
    public String saveStuds(@RequestBody List<Student> student){
        studentRepository.saveAll(student);
        return "student saved";
    }

    @GetMapping("getStuds")
    public String getStuds(){
        studentRepository.findAll();
        return "saved";
    }

    @GetMapping("getById/{id}")
    public Optional<Student> getById(@PathVariable Integer id){
        return studentRepository.findById(id);
    }

    @PutMapping("Update")
    public String Update(@RequestBody Student student){
        Student student1 = studentRepository.getReferenceById(student.getId());
        student1.setName(student.getName());
        student1.setAddress(student.getAddress());
        student1.setAge(student.getAge());

        studentRepository.save(student);
        return "update student";
    }

    @DeleteMapping("delete/{id}")
    public String Delete(@PathVariable("id") Integer id){
        studentRepository.deleteById(id);
        return "record deleted";
    }


}
