package gb.hw.hw_2.Models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class StudentRepo {
    private final List<Student> students;

    public StudentRepo() {
        this.students = new ArrayList<>();
        students.add(new Student("Student1", "MATH"));
        students.add(new Student("Student2", "LAW"));
        students.add(new Student("Student3", "IT"));
        students.add(new Student("Student4", "PSYCHOLOGY"));
        students.add(new Student("Student5", "PSYCHOLOGY"));
        students.add(new Student("Student6", "IT"));
        students.add(new Student("Student7", "PSYCHOLOGY"));
        students.add(new Student("Student8", "MATH"));
        students.add(new Student("Student9", "MATH"));
        students.add(new Student("Roma", "IT"));

    }

    public List<Student> getAll() {
        return List.copyOf(students);
    }

    public Student getById(long id) {
        return students.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst().orElse(null);
    }

    public Student getByName(String name) {
        return students.stream()
                .filter(it -> Objects.equals(it.getName(), name))
                .findFirst().orElse(null);
    }

    public List<Student> getByGroup(String groupName) {
        List<Student> res = students.stream()
                .filter(it -> Objects.equals(it.getNameOfGroup(), groupName))
                .collect(Collectors.toList());
        return res;
    }

    public Student createUser(String name, String nameOfGroup) {
        Student newStudent = new Student(name, nameOfGroup);
        students.add(newStudent);
        return newStudent;
    }

    public List<Student> deleteStudent(long id) {
        Student exist = getById(id);
        if (exist == null) {
            System.out.println("Do not exist student!");
        } else {
            students.remove(exist);
        }
        return students;
    }
}
