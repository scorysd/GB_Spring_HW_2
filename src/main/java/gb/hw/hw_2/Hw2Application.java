package gb.hw.hw_2;

import gb.hw.hw_2.Models.StudentRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Hw2Application {



    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Hw2Application.class, args);
        StudentRepo studentRepo =  context.getBean(StudentRepo.class);
    }
}
