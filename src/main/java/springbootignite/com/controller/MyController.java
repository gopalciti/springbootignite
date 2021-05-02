package springbootignite.com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import springbootignite.com.model.Person2;
import springbootignite.com.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/person")
public class MyController {
    @Autowired
    private PersonService personService;



    @GetMapping("/{id}")
    public Person2 getPerson(@PathVariable Long id){
        return personService.getPerson(id);
    }




}