package org.put_the_machine.ies.cofig.dev;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import lombok.val;
import org.put_the_machine.ies.model.*;
import org.put_the_machine.ies.model.user.Administrator;
import org.put_the_machine.ies.model.user.Manager;
import org.put_the_machine.ies.model.user.Student;
import org.put_the_machine.ies.model.user.Teacher;
import org.put_the_machine.ies.repository.DocumentRepository;
import org.put_the_machine.ies.service.CourseProfileService;
import org.put_the_machine.ies.service.DepartmentService;
import org.put_the_machine.ies.service.InstituteService;
import org.put_the_machine.ies.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.MimeType;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Profile("dev")
@Configuration
@PropertySource("classpath:application-dev.yaml")
public class DevConfig {



    @Bean
    CommandLineRunner insertTestData(
            UserService userService,
            DepartmentService depService,
            DocumentRepository docRepo,
            CourseProfileService courseProfileService,
            InstituteService instituteService,
            PasswordEncoder passwordEncoder) {
        return args -> {
            val administrator = new Administrator();
            administrator.setUsername("username");
            administrator.setPassword("password");
            administrator.setEmail(new Email("test@gmail.com"));
            userService.save(administrator);

            val student = new Student();
            student.setUsername("student");
            student.setSubjectGroups(new HashSet<>());
            student.setPassword(passwordEncoder.encode("password"));
            student.setFullName("Даниил Яндыбаев Игоревич");
            student.setEmail(new Email("test1@gmail.com"));


            val manager = new Manager();
            manager.setUsername("manager");
            manager.setPassword("password");
            manager.setEmail(new Email("test2@gmail.com"));
            userService.save(manager);


            val teacher = new Teacher();
            teacher.setFullName("Александр Вадимович");
            teacher.setUsername("teacher");
            teacher.setPassword(passwordEncoder.encode("password"));
            teacher.setEmail(new Email("test3@gmail.com"));
            //userService.save(teacher);

            //------------------------------------------------------------------------

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
            courseProfile.setName("");
            courseProfile.setDefault(false);
            courseProfileService.save(courseProfile);

            //--------------------------------------------------------------------------------

            val inpitInstitute = new Institute();
            inpitInstitute.setName("ИнПИТ");
            inpitInstitute.setDepartments(new HashSet<>());

            val pitDepartment = new Department();
            pitDepartment.setName("ПИТ");
            pitDepartment.setInstitute(inpitInstitute);
            inpitInstitute.getDepartments().add(pitDepartment);
            pitDepartment.setCourses(new HashSet<>());

            Course ifstCourse = new Course();
            ifstCourse.setName("ИФСТ");
            ifstCourse.setDepartment(pitDepartment);
            pitDepartment.getCourses().add(ifstCourse);
            ifstCourse.setDescription("Прикольное направление для топов");
            ifstCourse.setCourseProfiles(new HashSet<>());

            CourseProfile ifst1ProfileBak = new CourseProfile();
            ifst1ProfileBak.setName("ИФСТ 1 профиль Бакалавриат");
            ifst1ProfileBak.setCourse(ifstCourse);
            ifstCourse.getCourseProfiles().add(ifst1ProfileBak);

            CourseProfile ifst2ProfileBak = new CourseProfile();
            ifst2ProfileBak.setName("ИФСТ 1 профиль Бакалавриат");
            ifst2ProfileBak.setCourse(ifstCourse);
            ifstCourse.getCourseProfiles().add(ifst2ProfileBak);

            CourseProfile defaultProfileIfst = new CourseProfile();
            defaultProfileIfst.setName("ИФСТ дефолтный профиль");
            defaultProfileIfst.setCourse(ifstCourse);
            ifstCourse.getCourseProfiles().add(defaultProfileIfst);


            val ikspDepartment = new Department();
            ikspDepartment.setName("СМ");
            ikspDepartment.setInstitute(inpitInstitute);
            inpitInstitute.getDepartments().add(ikspDepartment);
            ikspDepartment.setCourses(new HashSet<>());

            Course pingCourse = new Course();
            pingCourse.setName("ПИНЖ");
            pingCourse.setDescription("Тоже ниче так, но иногда приходится напоминать, что ПИНЖ lives matters");
            pingCourse.setDepartment(ikspDepartment);
            ikspDepartment.getCourses().add(pingCourse);
            pingCourse.setCourseProfiles(new HashSet<>());

            CourseProfile pingCourseProfile = new CourseProfile();
            pingCourseProfile.setName("ПИНЖ");
            pingCourseProfile.setCourse(pingCourse);
            pingCourse.getCourseProfiles().add(pingCourseProfile);
            pingCourseProfile.setGroups(new HashSet<>());
            pingCourseProfile.setStudyPlanSubjects(new HashSet<>());

            Subject economySubject = new Subject();
            economySubject.setStudyPlanSubjects(new HashSet<>());
            economySubject.setSubjectGroups(new HashSet<>());
            economySubject.setName("ЭКОНОМИКА");
            StudyPlanSubject economyStudyPlanSubject = new StudyPlanSubject();
            economyStudyPlanSubject.setSemester(4);
            economyStudyPlanSubject.setReportType(StudyPlanSubject.ReportType.Test);
            economyStudyPlanSubject.setSubject(economySubject);
            economySubject.getStudyPlanSubjects().add(economyStudyPlanSubject);
            economyStudyPlanSubject.setCourseProfile(pingCourseProfile);
            pingCourseProfile.getStudyPlanSubjects().add(economyStudyPlanSubject);

            Subject oopSubject = new Subject();
            oopSubject.setStudyPlanSubjects(new HashSet<>());
            oopSubject.setSubjectGroups(new HashSet<>());
            oopSubject.setName("Современный ООП (поставьте зачет, пожалуйста)");
            StudyPlanSubject oopStudyPlanSubject = new StudyPlanSubject();
            oopStudyPlanSubject.setSemester(4);
            oopStudyPlanSubject.setReportType(StudyPlanSubject.ReportType.Test);
            oopStudyPlanSubject.setSubject(oopSubject);
            oopSubject.getStudyPlanSubjects().add(oopStudyPlanSubject);
            oopStudyPlanSubject.setCourseProfile(pingCourseProfile);
            pingCourseProfile.getStudyPlanSubjects().add(oopStudyPlanSubject);

            SubjectGroup practiceSubjectGroup = new SubjectGroup();
            practiceSubjectGroup.setDocumentMetaInfos(new HashSet<>());
            practiceSubjectGroup.setHours(99999999);
            practiceSubjectGroup.setName("ООП Практика(тут файлы)");
            practiceSubjectGroup.setStudents(new HashSet<>());
            practiceSubjectGroup.getStudents().add(student);
            student.getSubjectGroups().add(practiceSubjectGroup);
            practiceSubjectGroup.setSubject(oopSubject);
            practiceSubjectGroup.setTeacher(teacher);
            practiceSubjectGroup.setType(SubjectGroup.SubjectGroupType.PRACTICE);

            DocumentMetaInfo doc1 = new DocumentMetaInfo();
            doc1.setRealPath("theBestTasks.doc");
            doc1.setVirtualPath("");
            doc1.setSubjectGroup(practiceSubjectGroup);
            doc1.setName("Лучшие задачи по ООП и каратэ");
            doc1.setMimeType(MimeType.valueOf("plain/text"));
            doc1.setIsFile(true);
            doc1.setCreationTime(LocalDateTime.now());
            practiceSubjectGroup.getDocumentMetaInfos().add(doc1);

            DocumentMetaInfo doc2 = new DocumentMetaInfo();
            doc2.setRealPath("theBestTasksSpring.doc");
            doc2.setVirtualPath("");
            doc2.setSubjectGroup(practiceSubjectGroup);
            doc2.setName("Лучшие задачи по ООП и спрингу");
            doc2.setMimeType(MimeType.valueOf("plain/text"));
            doc2.setIsFile(true);
            doc2.setCreationTime(LocalDateTime.now());
            practiceSubjectGroup.getDocumentMetaInfos().add(doc2);

            DocumentMetaInfo folder1 = new DocumentMetaInfo();
            folder1.setVirtualPath("");
            folder1.setIsFile(false);
            folder1.setSubjectGroup(practiceSubjectGroup);
            folder1.setName("Карате-пацаны лучшие задачи");
            folder1.setCreationTime(LocalDateTime.now());
            practiceSubjectGroup.getDocumentMetaInfos().add(folder1);

            DocumentMetaInfo doc3 = new DocumentMetaInfo();
            doc3.setRealPath("theBestTaskAboutKarate.doc");
            doc3.setVirtualPath("Карате-пацаны лучшие задачи");
            doc3.setSubjectGroup(practiceSubjectGroup);
            doc3.setName("Карате-пацан 1");
            doc3.setMimeType(MimeType.valueOf("plain/text"));
            doc3.setIsFile(true);
            doc3.setCreationTime(LocalDateTime.now());
            practiceSubjectGroup.getDocumentMetaInfos().add(doc3);

            DocumentMetaInfo doc4 = new DocumentMetaInfo();
            doc4.setRealPath("theBestTaskAboutKarate2.doc");
            doc4.setVirtualPath("Карате-пацаны лучшие задачи");
            doc4.setSubjectGroup(practiceSubjectGroup);
            doc4.setName("Карате-пацан 2");
            doc4.setMimeType(MimeType.valueOf("plain/text"));
            doc4.setIsFile(true);
            doc4.setCreationTime(LocalDateTime.now());
            practiceSubjectGroup.getDocumentMetaInfos().add(doc4);

            DocumentMetaInfo folder2 = new DocumentMetaInfo();
            folder2.setVirtualPath("Карате-пацаны лучшие задачи");
            folder2.setIsFile(false);
            folder2.setSubjectGroup(practiceSubjectGroup);
            folder2.setName("Карате-пацан история создания");
            folder2.setCreationTime(LocalDateTime.now());
            practiceSubjectGroup.getDocumentMetaInfos().add(folder2);

            DocumentMetaInfo doc5 = new DocumentMetaInfo();
            doc5.setRealPath("theBestTaskAboutKarate2.doc");
            doc5.setVirtualPath("Карате-пацаны лучшие задачи/Карате-пацан история создания");
            doc5.setSubjectGroup(practiceSubjectGroup);
            doc5.setName("Режиссерская версия");
            doc5.setMimeType(MimeType.valueOf("plain/text"));
            doc5.setIsFile(true);
            doc5.setCreationTime(LocalDateTime.now());
            practiceSubjectGroup.getDocumentMetaInfos().add(doc5);


            SubjectGroup lectureSubjectGroup = new SubjectGroup();
            lectureSubjectGroup.setDocumentMetaInfos(new HashSet<>());
            lectureSubjectGroup.setHours(99999999);
            lectureSubjectGroup.setName("ООП Лекции");
            lectureSubjectGroup.setStudents(new HashSet<>());
            lectureSubjectGroup.getStudents().add(student);
            student.getSubjectGroups().add(lectureSubjectGroup);
            lectureSubjectGroup.setSubject(oopSubject);
            lectureSubjectGroup.setTeacher(teacher);
            lectureSubjectGroup.setType(SubjectGroup.SubjectGroupType.LECTURE);


            Group ping21Group = new Group();
            ping21Group.setName("Пинж группа лучшая!");
            ping21Group.setSemester(4L);
            ping21Group.setStudents(new HashSet<>());
            student.setGroups(new HashSet<>());
            student.getGroups().add(ping21Group);
            ping21Group.getStudents().add(student);
            ping21Group.setCourseProfile(pingCourseProfile);
            pingCourseProfile.getGroups().add(ping21Group);

            val mkmDepartment = new Department();
            mkmDepartment.setName("МКМ");
            mkmDepartment.setInstitute(inpitInstitute);
            inpitInstitute.getDepartments().add(mkmDepartment);

            val ibsDepartment = new Department();
            ibsDepartment.setName("ИБС");
            ibsDepartment.setInstitute(inpitInstitute);
            inpitInstitute.getDepartments().add(ibsDepartment);

            instituteService.save(inpitInstitute);

            //--------------------------------------------------------------------------------

            val immInstitute = new Institute();
            immInstitute.setName("ИММ");
            immInstitute.setDepartments(new HashSet<>());


            val mbiDepartment = new Department();
            mbiDepartment.setName("МБИ");
            mbiDepartment.setInstitute(immInstitute);
            immInstitute.getDepartments().add(mbiDepartment);

            val smDepartment = new Department();
            smDepartment.setName("СМ");
            smDepartment.setInstitute(immInstitute);
            immInstitute.getDepartments().add(smDepartment);

            instituteService.save(immInstitute);
            //--------------------------------------------------------------------------------

            val ietipInstitute = new Institute();
            ietipInstitute.setName("ИЭТИП");
            ietipInstitute.setDepartments(new HashSet<>());

            val eluDepartment = new Department();
            eluDepartment.setName("ЭЛУ");
            eluDepartment.setInstitute(ietipInstitute);
            ietipInstitute.getDepartments().add(eluDepartment);

            val rtDepartment = new Department();
            rtDepartment.setName("РТ");
            rtDepartment.setInstitute(ietipInstitute);
            ietipInstitute.getDepartments().add(rtDepartment);

            val pbsDepartment = new Department();
            pbsDepartment.setName("ПБС");
            pbsDepartment.setInstitute(ietipInstitute);
            ietipInstitute.getDepartments().add(pbsDepartment);

            val sutsDepartment = new Department();
            sutsDepartment.setName("СУТС");
            sutsDepartment.setInstitute(ietipInstitute);
            ietipInstitute.getDepartments().add(sutsDepartment);

            instituteService.save(ietipInstitute);
            //--------------------------------------------------------------------------------
            for (Institute institute : instituteService.getInstitutesWithFullDepartmentInfo()) {
                System.out.println(institute);
            }
        };
    }
}
