package klu.studentcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import klu.studentcrud.entity.Student;
import klu.studentcrud.service.StudentService;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:3001")
public class StudentController 
{
    @Autowired
    private StudentService service;

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student)
    {
        Student saved = service.addStudent(student);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents()
    {
        return new ResponseEntity<>(service.getAllStudents(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody Student student)
    {
        Student updated = service.updateStudent(id, student);

        if(updated != null)
        {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }

        return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id)
    {
        boolean deleted = service.deleteStudent(id);

        if(deleted)
        {
            return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
        }

        return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
    }
}