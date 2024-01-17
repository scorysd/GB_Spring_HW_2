package gb.hw.hw_2.Controllers;

import gb.hw.hw_2.Models.Student;
import gb.hw.hw_2.Models.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentRepo studentRepo;

    @GetMapping("/student")
    public List<Student> getAll() {
        return studentRepo.getAll();
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable long id) {
        return studentRepo.getById(id);
    }

    @GetMapping("/student/search")
    public Student getStudentByName(@RequestParam String name) {
        return studentRepo.getByName(name);
    }

    @GetMapping("/group/{groupName}/student")
    public List<Student> getStudentByGroup(@PathVariable String groupName) {
        return studentRepo.getByGroup(groupName);
    }

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student) {
        return studentRepo.createUser(student.getName(), student.getNameOfGroup());
    }
    @DeleteMapping("/student/{id}")
    public List<Student> deleteStudent(@PathVariable long id){
        return studentRepo.deleteStudent(id);
    }
}
