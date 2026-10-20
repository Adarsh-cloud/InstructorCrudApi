package com.onetoone.controller;

import com.onetoone.dto.InstructorDTO;
import com.onetoone.service.InstructorService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OneToOneController {

    private InstructorService instructorService;

    @Autowired
    public OneToOneController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/oneToOne")
    public String oneToOne() {
        return "oneToOne";
    }

    @GetMapping("/instructors")
    public ResponseEntity<List<InstructorDTO>> getAllInstructors() {
        return  new ResponseEntity<>(instructorService.getAllInstructors(), HttpStatus.OK);
    }

    @GetMapping("/instructors/{id}")
    public ResponseEntity<InstructorDTO> getInstructorById(@PathVariable Integer id) {
        return  new ResponseEntity<>(instructorService.getInstructorById(id), HttpStatus.OK);
    }

    @PostMapping("/instructors")
    public ResponseEntity<String> createInstructor(@RequestBody InstructorDTO instructorDTO){
       instructorService.addInstructor(instructorDTO);
       return  new ResponseEntity<>("Instructor created successfully",HttpStatus.CREATED);

    }
    @DeleteMapping("instructors/{id}")
    public ResponseEntity<String> deleteInstructor(@PathVariable Integer id){
        instructorService.deleteInstructorById(id);
        return  new ResponseEntity<>("Instructor deleted successfully",HttpStatus.OK);
    }
    @PutMapping("/instructors/{id}")
    public ResponseEntity<String> updateInstructor(@PathVariable Integer id, @RequestParam String firstName, @RequestParam String lastName){
        InstructorDTO instructorDTO = instructorService.updateInstructor(id, firstName, lastName);
        return  new ResponseEntity<>("Instructor updated successfully",HttpStatus.OK);
    }

}
