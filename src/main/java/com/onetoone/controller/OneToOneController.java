package com.onetoone.controller;

import com.onetoone.dto.InstructorDTO;
import com.onetoone.service.InstructorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
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
    public ResponseEntity<InstructorDTO> getInstructorById(@Max(5) @PathVariable Integer id) {
        return  new ResponseEntity<>(instructorService.getInstructorById(id), HttpStatus.OK);
    }

    @PostMapping("/instructors")
    public ResponseEntity<String> createInstructor(@Valid @RequestBody InstructorDTO instructorDTO){
       instructorService.addInstructor(instructorDTO);
       return  new ResponseEntity<>("Instructor created successfully",HttpStatus.CREATED);

    }
    @DeleteMapping("instructors/{id}")
    public ResponseEntity<String> deleteInstructor(@Max(10) @PathVariable Integer id){
        instructorService.deleteInstructorById(id);
        return  new ResponseEntity<>("Instructor deleted successfully",HttpStatus.OK);
    }
    @PutMapping("/instructors/{id}")
    public ResponseEntity<String> updateInstructor(@PathVariable Integer id, @RequestParam String firstName, @RequestParam String lastName){
        InstructorDTO instructorDTO = instructorService.updateInstructor(id, firstName, lastName);
        return  new ResponseEntity<>("Instructor updated successfully",HttpStatus.OK);
    }

}
