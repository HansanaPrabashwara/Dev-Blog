package io.crud.crud.repository;

import io.crud.crud.model.Post;

import java.util.List;

public interface SearchRepository {
    List<Post> findByText(String text);
}
