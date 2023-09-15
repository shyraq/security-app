package com.example.FirstSecurityApp.services;

import com.example.FirstSecurityApp.models.Person;
import com.example.FirstSecurityApp.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public AdminService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Transactional
    public void makeAdmin(Person person){
        person.setRole("ROLE_ADMIN");
        peopleRepository.save(person);
    }

    @Transactional
    public void deleteUser(Person person){
        peopleRepository.deleteById(person.getId());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void onlyAdminHere(){
        System.out.println("Only admin here");
    }
}
