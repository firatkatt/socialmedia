package com.project.socialmedia.controller;

import com.project.socialmedia.Dto.PostCreateRequest;
import com.project.socialmedia.Dto.PostResponse;
import com.project.socialmedia.Dto.PostUpdateRequest;
import com.project.socialmedia.model.Post;
import com.project.socialmedia.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    @GetMapping
    public List<PostResponse> getAllPosts(@RequestParam Optional<Long> userId) {
        return postService.getAllPosts(userId);
    }

    @PostMapping
    public Post createOnePost(@RequestBody PostCreateRequest newPostRequest) {
        return postService.createOnePost(newPostRequest);
    }


    @GetMapping("/{postId}")
    public PostResponse getOnePost(@PathVariable Long postId) {
        return postService.getOnePostByIdWithLikes(postId);
    }

    @PutMapping("/{postId}")
    public Post updateOnePost(@PathVariable Long postId, @RequestBody PostUpdateRequest updatePost) {
        return postService.updateOnePostById(postId, updatePost);
    }

    @DeleteMapping("/{postId}")
    public void deleteOnePost(@PathVariable Long postId) {
        postService.deleteOnePostById(postId);
    }
}
