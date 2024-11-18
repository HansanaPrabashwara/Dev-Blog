package io.crud.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.crud.crud.model.Post;
import io.crud.crud.repository.PostRepository;
import io.crud.crud.repository.SearchRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@CrossOrigin
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private SearchRepository searchRepository;

    @GetMapping("/")
    List<Post> getPosts() {
        return postRepository.findAll();
    }
    
    @GetMapping("/{id}")
    Post getPost(@PathVariable String id) {
        Post post = postRepository.findById(id).orElse(null);
        post.setViews(post.getViews() + 1);
        postRepository.save(post);
        return post;
    }

    @GetMapping("search/")
    List <Post> searchPosts() {
        return searchRepository.findByText("Hello World");
    }

    @PostMapping("/")
    Post getPost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @PutMapping("/{id}")
    Post putPost(@PathVariable String id, @RequestBody Post post) {
        Post oldPost = postRepository.findById(id).orElse(null);
        oldPost.setTitle(post.getTitle());
        oldPost.setContent(post.getContent());
        return postRepository.save(oldPost);
    }

    @DeleteMapping("/{id}")
    String deletePost(@PathVariable String id) {
        postRepository.deleteById(id);
        return id;
    }   
}
