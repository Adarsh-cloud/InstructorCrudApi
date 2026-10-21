package com.onetoone.service.instructor;

import com.onetoone.dto.InstructorDTO;

import java.util.List;

public interface InstructorService {
    public void addInstructor(InstructorDTO instructorDTO);
    public InstructorDTO getInstructorById(Integer id);
    public List<InstructorDTO> getAllInstructors();
    public void deleteInstructorById(Integer id);

    InstructorDTO updateInstructor(Integer id, String firstName, String lastName);
}
