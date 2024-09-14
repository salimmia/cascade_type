package com.salim.cascadetype.mainTask.repositories;

import com.salim.cascadetype.mainTask.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {  // String is the type of the ID
}

