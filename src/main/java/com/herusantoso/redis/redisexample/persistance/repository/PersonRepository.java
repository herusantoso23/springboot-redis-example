package com.herusantoso.redis.redisexample.persistance.repository;

import com.herusantoso.redis.redisexample.persistance.domain.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, String>{
    List<Person> findAll();

}
