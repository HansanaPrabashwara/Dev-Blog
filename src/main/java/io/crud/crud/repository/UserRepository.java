package io.crud.crud.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import io.crud.crud.model.User;

public interface UserRepository extends MongoRepository<User, String>{

}