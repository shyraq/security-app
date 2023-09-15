package com.example.FirstSecurityApp.repositories;

import com.example.FirstSecurityApp.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer>{

    Optional<Person> findByUsername(String userName);

    List<Person> findAll();

     Person findById(int id);

}
