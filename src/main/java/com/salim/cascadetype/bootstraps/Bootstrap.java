package com.salim.cascadetype.bootstraps;

import com.salim.cascadetype.author.domain.Author;
import com.salim.cascadetype.course.domain.Course;
import com.salim.cascadetype.course.repository.CourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    CourseRepository courseRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Smith");
        author.setEmail("john.smith@gmail.com");

        Course course = new Course();
        course.setCourseName("Spring Boot");
        course.setDescription("Spring Boot course");
        course.setAuthor(author);
        courseRepository.save(course);

//        Author author2 = new Author();
//        author2.setFirstName("Jane");
//        author2.setLastName("Smith");
//        author2.setEmail("jane.smith@gmail.com");

        Course course1 = new Course();
        course1.setCourseName("Spring");
        course1.setDescription("Spring course");
        course1.setAuthor(author);
//        course1.setAuthor(author2);

        System.out.println("Author ID: " + author.getId());
        courseRepository.save(course1);
    }
}
