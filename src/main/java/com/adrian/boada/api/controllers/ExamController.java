package com.adrian.boada.api.controllers;
import com.adrian.boada.api.repositories.examRepository;
import com.adrian.boada.api.entities.exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.Optional;
import java.util.List;

@Controller
public class ExamController
{

    private examRepository examRepository;

    @Autowired
    public ExamController(examRepository examRepository) {
        this.examRepository = examRepository;
    }

    public List<exam> findAllexam() {
        return this.examRepository.findAll();
    }

    public Optional<exam> findExambyId(int id){
        return this.examRepository.findById(id);
    }


    public void createProduct(exam exam){
        this.examRepository.save(exam);
    }

    public boolean editExamById(int id, exam exam){
        Optional<exam> examOptional = this.findExambyId(id);
        if( !examOptional.isPresent()) return false;
        exam exam1 = examOptional.get();
        exam1.setBrand(exam.getBrand());
        exam1.setModel(exam.getModel());
        exam1.setPrice(exam.getPrice());
        examRepository.save(exam1);
        return true;
    }

    public boolean deleteExamById(int id) {
        Optional<exam> examOptional = this.findExambyId(id);
        if (!examOptional.isPresent()) return false;
        examRepository.deleteById(id);
        return true;
    }



}
