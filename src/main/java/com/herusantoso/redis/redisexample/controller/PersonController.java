package com.herusantoso.redis.redisexample.controller;

import com.herusantoso.redis.redisexample.service.PersonService;
import com.herusantoso.redis.redisexample.vo.PersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    PersonService personService;

    @RequestMapping(value = "/add",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean add(@RequestBody PersonVO vo){
        return personService.savePerson(vo);
    }

    @RequestMapping(value = "/update",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean update(@RequestBody PersonVO vo){
        return personService.updatePerson(vo);
    }

    @RequestMapping(value = "/delete/{id}",
            method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable(value="id") String id){
        return personService.deletePerson(id);
    }

    @RequestMapping(value = "/get-all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonVO> getAll(){
        return personService.getAll();
    }

    @RequestMapping(value = "/get-detail",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO getDetail(@RequestParam(value="id") String id){
        return personService.getDetail(id);
    }




}
