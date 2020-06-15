package org.put_the_machine.ies.cofig.dev;

import lombok.val;
import org.put_the_machine.ies.model.Course;
import org.put_the_machine.ies.model.CourseProfile;
import org.put_the_machine.ies.model.Department;
import org.put_the_machine.ies.model.Email;
import org.put_the_machine.ies.model.user.Administrator;
import org.put_the_machine.ies.model.user.Manager;
import org.put_the_machine.ies.model.user.Student;
import org.put_the_machine.ies.model.user.Teacher;
import org.put_the_machine.ies.repository.DocumentRepository;
import org.put_the_machine.ies.service.CourseProfileService;
import org.put_the_machine.ies.service.DepartmentService;
import org.put_the_machine.ies.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Profile("dev")
@Configuration
@PropertySource("classpath:application-dev.yaml")
public class DevConfig {

    @Bean
    public ViewResolver thymeleafViewResolver() {

        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();

        viewResolver.setTemplateEngine(thymeleafTemplateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setOrder(0);

        return viewResolver;
    }

    @Bean
    public SpringTemplateEngine thymeleafTemplateEngine() {

        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(thymeleafTemplateResolver());
        templateEngine.setEnableSpringELCompiler(true);

        return templateEngine;
    }

    @Bean
    public SpringResourceTemplateResolver springResourceTemplateResolver() {
        return new SpringResourceTemplateResolver();
    }

    @Bean
    public ITemplateResolver thymeleafTemplateResolver() {

        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();

        templateResolver.setCacheable(false);
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");

        return templateResolver;
    }

    @Bean
    CommandLineRunner insertTestData(
            UserService userService,
            DepartmentService depService,
            DocumentRepository docRepo,
            CourseProfileService courseProfileService) {
        return args -> {
            val administrator = new Administrator();
            administrator.setUsername("username");
            administrator.setPassword("password");
            administrator.setEmail(new Email("test@gmail.com"));
            userService.save(administrator);

            val student = new Student();
            student.setUsername("student");
            student.setPassword("password");
            student.setEmail(new Email("test1@gmail.com"));
            userService.save(student);

            val manager = new Manager();
            manager.setUsername("manager");
            manager.setPassword("password");
            manager.setEmail(new Email("test2@gmail.com"));
            userService.save(manager);


            val teacher = new Teacher();
            teacher.setUsername("teacher");
            teacher.setPassword("password");
            teacher.setEmail(new Email("test3@gmail.com"));
            userService.save(teacher);
            Department dep = new Department();
            Course course = new Course();
            course.setName("blabla");
            course.setDepartment(dep);
            Set<Course> courseSet = new HashSet<>();
            courseSet.add(course);
            dep.setCourses(courseSet);

            val courseProfile = new CourseProfile();
            courseProfile.setCourse(course);
            course.setCourseProfiles(Collections.singleton(courseProfile));
            courseProfile.setName("Course");
            courseProfile.setDefault(false);
            courseProfileService.save(courseProfile);

        };
    }
}
