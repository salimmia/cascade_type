package com.salim.cascadetype.mainTask.repositories;

import com.salim.cascadetype.mainTask.StringWrapper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StringRepository extends JpaRepository<StringWrapper, Long> {
}
