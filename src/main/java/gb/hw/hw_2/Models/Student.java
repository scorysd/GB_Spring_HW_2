package gb.hw.hw_2.Models;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;

@Data
public class Student {
    private static long idCount = 1L;
    private final long id;
    private final String name;
    private String nameOfGroup;

    public Student(String name, String nameOfGroup) {
        this.id = idCount++;
        this.name = name;
        this.nameOfGroup = nameOfGroup;
    }

    @JsonCreator
    public Student(long id, String name, String nameOfGroup) {
        this.id = id;
        this.name = name;
        this.nameOfGroup = nameOfGroup;
    }
}
