package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional=studentRepository.getStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }

        studentRepository.save(student);
    }

    public void deleteStudentById(long studentId) {
        boolean check=studentRepository.existsById(studentId);
        if(check){
            studentRepository.deleteById(studentId);
        }
        else{
            throw new IllegalStateException("no student with this id");
        }
    }

//    @Transactional
//    public void updateStudentbyId(long studentId, String name, String email) {
//        boolean check=studentRepository.existsById(studentId);
//        if(check){
//            Optional<Student> student=studentRepository.findById(studentId);
//            student.setName(name);
//            student.setEmail(email);
//        }
//        else
//            throw new IllegalStateException("no student with this id");
//    }
}
