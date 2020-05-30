package org.put_the_machine.ies.cofig;

import lombok.val;
import org.put_the_machine.ies.model.Email;
import org.put_the_machine.ies.model.user.Administrator;
import org.put_the_machine.ies.model.user.Manager;
import org.put_the_machine.ies.model.user.Student;
import org.put_the_machine.ies.model.user.Teacher;
import org.put_the_machine.ies.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;

@Profile("dev")
@Configuration
@PropertySource("classpath:application-dev.yaml")
public class DevConfig {

    @Bean
    CommandLineRunner insertTestData(UserService userService) {
        return args -> {
            val administrator = new Administrator();
            administrator.setUsername("username");
            administrator.setPassword("password");
            administrator.setEmail(new Email("test@gmail.com"));
            userService.save(administrator);

            val student = new Student();
            student.setUsername("student");
            student.setPassword("password");
            student.setEmail(new Email("test@gmail.com"));
            userService.save(student);

            val manager = new Manager();
            manager.setUsername("manager");
            manager.setPassword("password");
            manager.setEmail(new Email("test@gmail.com"));
            userService.save(manager);


            val teacher = new Teacher();
            teacher.setUsername("teacher");
            teacher.setPassword("password");
            teacher.setEmail(new Email("test@gmail.com"));
            userService.save(teacher);


        };
    }
}
