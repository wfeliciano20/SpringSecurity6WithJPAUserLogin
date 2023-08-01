package com.williamfeliciano.danvegaspringsecurity6withdb.service;

import com.williamfeliciano.danvegaspringsecurity6withdb.model.Post;
import com.williamfeliciano.danvegaspringsecurity6withdb.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{


    @Autowired
    private PostRepository postRepository;
    @Override
    public List<Post> getAllPosts() {
        return (List<Post>) postRepository.findAll();
    }

    @Override
    public Optional<Post> getPostById(Long id) {
        String s = "No Post with provided id";
        return Optional.of(postRepository.findById(id)).orElseThrow(()-> new RuntimeException("No post with provided id"));
    }

    @Override
    public Object createPost(Post post) {
        return postRepository.save(post);
    }
}
