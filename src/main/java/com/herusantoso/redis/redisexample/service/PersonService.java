package com.herusantoso.redis.redisexample.service;

import com.herusantoso.redis.redisexample.persistance.domain.Person;
import com.herusantoso.redis.redisexample.persistance.repository.PersonRepository;
import com.herusantoso.redis.redisexample.vo.PersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public Boolean savePerson(PersonVO personVO){
        Person person= new Person();
        person.setId(personVO.getId());
        person.setName(personVO.getName());
        person.setAddress(personVO.getAddress());

        personRepository.save(person);

        return true;
    }

    public Boolean updatePerson(PersonVO vo){
        Person person = personRepository.findOne(vo.getId());
        person.setName(vo.getName());
        person.setAddress(vo.getAddress());

        personRepository.save(person);

        return true;
    }

    public boolean deletePerson(String id){
        Person person = personRepository.findOne(id);
        personRepository.delete(person);

        return true;
    }

    public List<PersonVO> getAll(){
        List<Person> listResult = personRepository.findAll();

        List<PersonVO> personVOS = new ArrayList<>();
        for(Person p : listResult){
            PersonVO vo = new PersonVO();
            vo.setId(p.getId());
            vo.setName(p.getName());
            vo.setAddress(p.getAddress());

            personVOS.add(vo);
        }

        return personVOS;
    }

    public PersonVO getDetail(String id){
        Person person = personRepository.findOne(id);
        PersonVO personVO = new PersonVO();
        personVO.setId(person.getId());
        personVO.setName(person.getName());
        personVO.setAddress(person.getAddress());

        return personVO;
    }
}
