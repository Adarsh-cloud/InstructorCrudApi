package com.onetoone.service;

import com.onetoone.dao.InstructorRepo;
import com.onetoone.dto.InstructorDTO;
import com.onetoone.entity.Instructor;
import com.onetoone.exception.InstructorNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService{

    private static final Logger logger = LoggerFactory.getLogger(InstructorServiceImpl.class);

    private InstructorRepo instructorRepo;

    private ModelMapper modelMapper;
    @Autowired
    public InstructorServiceImpl(InstructorRepo instructorRepo, ModelMapper modelMapper) {
        this.instructorRepo = instructorRepo;
        this.modelMapper = modelMapper;
    }

    @Transactional
    @Override
    public void addInstructor(InstructorDTO instructorDTO) {
        Instructor instructor = modelMapper.map(instructorDTO, Instructor.class);
        instructorRepo.save(instructor);
    }

    @Override
    public InstructorDTO getInstructorById(Integer id) {
        Optional<Instructor> instructor = instructorRepo.findById(id);
        if (instructor.isPresent()){
            return modelMapper.map(instructor.get(),InstructorDTO.class);
        }
        else{
           logger.error("Instructor with id {} not found",id);
           throw new InstructorNotFoundException("Instructor with id "+id+" doesnt exists");
        }

    }

    @Override
    public List<InstructorDTO> getAllInstructors() {
        List<Instructor> instructorList = instructorRepo.findAll();
        if(instructorList.isEmpty()){
            logger.error("Instructor list is empty");
        }
        List<InstructorDTO> instructorDTOList = new ArrayList<>();
        instructorList.forEach(instructor -> instructorDTOList.add(modelMapper.map(instructor, InstructorDTO.class)));

        return instructorDTOList;
    }

    @Transactional
    @Override
    public void deleteInstructorById(Integer id) {
        Optional<Instructor> instructorOpt = instructorRepo.findById(id);
        if(instructorOpt.isPresent()){
            instructorRepo.deleteById(id);
            logger.info("Instructor with id {} deleted",id);
        }
        else{
            throw new InstructorNotFoundException("Instructor with id "+id+" doesnt exists");
        }

    }

    @Transactional
    @Override
    public InstructorDTO updateInstructor(Integer id, String firstName, String lastName) {
        Optional<Instructor> instructor = instructorRepo.findById(id);
        if (instructor.isPresent()) {
            instructor.get().setFirstName(firstName);
            instructor.get().setLastName(lastName);
            return modelMapper.map(instructor.get(),InstructorDTO.class);
        } else {
            throw new InstructorNotFoundException("Instructor with id " + id + " doesnt exists");
        }


    }
}
