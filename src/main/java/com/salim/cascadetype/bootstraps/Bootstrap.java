package com.salim.cascadetype.bootstraps;

import com.salim.cascadetype.author.domain.Author;
import com.salim.cascadetype.course.domain.Course;
import com.salim.cascadetype.course.repository.CourseRepository;
//import com.salim.cascadetype.extraModule.IntegerWrapper;
//import com.salim.cascadetype.extraModule.Person;
//import com.salim.cascadetype.extraModule.StringWrapper;
//import com.salim.cascadetype.extraModule.repositories.IntegerWrapperRepository;
//import com.salim.cascadetype.extraModule.repositories.PersonRepository;
//import com.salim.cascadetype.extraModule.repositories.StringWrapperRepository;
import com.salim.cascadetype.mainTask.DataService;
import com.salim.cascadetype.mainTask.Manager;
import com.salim.cascadetype.mainTask.Person;
import com.salim.cascadetype.mainTask.StringWrapper;
import com.salim.cascadetype.teacher.domain.Teacher;
import com.salim.cascadetype.teacher.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    private DataService dataService;

    @Autowired
    private Manager<Object> manager;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        Author author = new Author();
        author.setFirstName("Muhammad");
        author.setLastName("Salim");
        author.setEmail("muhammad.salim@gmail.com");

        Course course = new Course();
        course.setCourseName("Spring Boot");
        course.setDescription("Spring Boot course");
        course.setAuthor(author);
        courseRepository.save(course);

        Course course1 = new Course();
        course1.setCourseName("Spring");
        course1.setDescription("Spring course");
        course1.setAuthor(author);

        System.out.println("Author ID: " + author.getId());
        courseRepository.save(course1);

        // Teacher
        Teacher teacher = new Teacher();
        teacher.setFirstName("Muhammad");
        teacher.setLastName("Salim");
        teacher.setEmail("muhammad@gmail.com");
        teacher.setCourses(Set.of(course, course1));

        teacherRepository.save(teacher);

        testInheritance();
    }

    private void testInheritance(){
        dataService.saveString("Hello, World!");
        StringWrapper stringEntity = new StringWrapper("Hello, World!");
        manager.add(stringEntity);

        Person person = new Person("Muhammad Salim", 26);
        dataService.savePerson(person);
        manager.add(person);

        Person person1 = new Person("Muhammad Salim", 25);
        Person person2 = new Person("Muhammad Halim", 35);
        dataService.saveGroup("Brothers", Set.of(person1, person2));
        manager.addList(List.of(person1, person2));

        manager.printContents();
        System.out.println("Groups: " + dataService.getAllGroups());
        System.out.println("All Person: " + dataService.getAllPersons());
        System.out.println("Strings: " + dataService.getAllStrings());
    }
}
