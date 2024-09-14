package com.salim.cascadetype.extraModule.repositories;

import com.salim.cascadetype.extraModule.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, String> {  // String is the type of the ID
}

