package com.example.joinup3.service;

import com.example.joinup3.entity.Post;
import com.example.joinup3.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // Create a new post
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    // Get all posts
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // Get post by ID
    public Post getPostById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found with ID: " + postId));
    }

    // Update a post
    public Post updatePost(Long postId, Post updatedPost) {
        Post post = getPostById(postId);
        post.setTitle(updatedPost.getTitle());
        post.setContent(updatedPost.getContent());
        return postRepository.save(post);
    }

    // Delete a post
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
