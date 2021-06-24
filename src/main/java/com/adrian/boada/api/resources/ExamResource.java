package com.adrian.boada.api.resources;

import com.adrian.boada.api.controllers.ExamController;
import com.adrian.boada.api.entities.exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.adrian.boada.api.resources.exceptions.EditexamException;
import com.adrian.boada.api.resources.exceptions.examCreateException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ExamResource.EXAM)
public class ExamResource {
    public static final String EXAM = "/exam";
    public static final String ID = "/{id}";


    private ExamController examController;

    @Autowired
    public ExamResource(ExamController examController) {
        this.examController = examController;
    }

    @GetMapping
    public List<exam>getAllExam(@RequestParam(required = false) String ci) {
        if (ci == null) return this.examController.findAllexam();
        return this.examController.findAllexam();

    }


    @GetMapping(value = ID)
    public ResponseEntity getExamById(@PathVariable int id) {
        Optional<exam> examOptional = this.examController.findExambyId(id);
        if (examOptional.isPresent()) {
            return new ResponseEntity(examOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity("\"El objeto no  esta existente\"", HttpStatus.NOT_FOUND);
        }

    }



    @PostMapping
    public ResponseEntity createExam(@RequestBody exam exam) throws examCreateException{
        try {
            this.examController.createProduct(exam);
            return new ResponseEntity("\"El objeto fue creado\"", HttpStatus.ACCEPTED);
        }
        catch (Exception e) {
        throw new examCreateException("los datos enviados no son los correctos");
    }

    }

    @PutMapping(value = ID)
    public ResponseEntity editExamById(@RequestBody exam exam, @PathVariable int id) throws EditexamException {
        try {
            if (this.examController.editExamById(id, exam))
                return new ResponseEntity("\"El objeto fue edito\"", HttpStatus.ACCEPTED);
            return new ResponseEntity("\"El objeto no  existe\"", HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {
            throw new EditexamException("los datos enviados no son los correctos");
        }
    }

    @DeleteMapping(value = ID)
    public  ResponseEntity deleteExam(@PathVariable int id)
        {
                if (this.examController.deleteExamById(id))
                    return new ResponseEntity("\"El objeto fue eliminado\"", HttpStatus.ACCEPTED);
                return new ResponseEntity("\"El objeto no  existe\"", HttpStatus.NOT_FOUND);


    }

}
