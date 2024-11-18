package io.crud.crud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.crud.crud.model.Post;

public interface PostRepository extends MongoRepository<Post, String> {

    
}
