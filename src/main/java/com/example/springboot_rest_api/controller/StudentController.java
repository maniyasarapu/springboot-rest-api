package com.example.springboot_rest_api.controller;


import com.example.springboot_rest_api.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("students")
public class StudentController {

    @GetMapping("/status")
    public String getStatus(){
        return "connected suceesfully";
    }

    @GetMapping
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(420,"mani","kanta");
//        return new ResponseEntity<>(student, HttpStatus.OK);
        return ResponseEntity.ok()
                .header("custom-header","testing")
                .body(student);
    }

    //single requestParam
    @GetMapping("id/query")
    public Student getStudentById(@RequestParam int id){
        return new Student(id,"MANI","KANTA");
    }

    //multiple requestParams
    @GetMapping("query")
    public Student getStudentByDetails(@RequestParam int id,
                                       @RequestParam String firstName,
                                       @RequestParam String lastName){
        return new Student(id,firstName,lastName);
    }

    // post API for creation
    @PostMapping("create")
    public Student createStudent(@RequestBody Student student){
        System.out.println("MAXXX :: STUDENT ::"+ student);
        return student;
    }

    // put API for updation of existing data
    @PutMapping("{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        student.setId(studentId);
        System.out.println("MAXXX :: STUDENT ::"+ student);
        return student;
    }

    // delete api for deleting a existing data
    @DeleteMapping("{id}/delete")
    public String deleteStudent(@PathVariable int id){
        return "student deleted";
    }



}
