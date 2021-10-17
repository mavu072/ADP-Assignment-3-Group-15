package za.ac.cput.ADP3LabBookingSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.ADP3LabBookingSystem.Entity.Student;
import za.ac.cput.ADP3LabBookingSystem.Factory.StudentFactory;
import za.ac.cput.ADP3LabBookingSystem.Service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public Student create(@RequestBody Student student)
    {
        Student newStudent = StudentFactory.build(
                student.getStudentNumber(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail());
        return studentService.create(newStudent);
    }

    @PostMapping("/read/{studentNumber}")
    public Student read(@PathVariable String studentNumber)
    {
        return studentService.read(studentNumber);
    }

    @PostMapping("/update")
    public Student update(@RequestBody Student student) {
        return studentService.update(student);
    }

    @PostMapping("/delete/{studentNumber}")
    public boolean delete(@PathVariable String studentNumber) {
        return studentService.delete(studentNumber);
    }

    @PostMapping("/getall")
    public List<Student> getAll(){
        return studentService.getAll();
    }
}
