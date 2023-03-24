package com.example.userestcontroller.controller.board;

import com.example.userestcontroller.model.board.Post;
import com.example.userestcontroller.service.board.PostService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
//@CrossOrigin(origins = "http://localhost:8181")
public class PostController {

    @Setter(onMethod_ = {@Autowired})
    private PostService postService;

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> showPostList() {
        List<Post> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/posts/{id}")
    public Post getPostById(@PathVariable Long id) {

        return postService.getPostById(id);
    }

    @PostMapping("/posts")
    public Post createPost(@RequestBody Post post) {

        return postService.createPost(post);
    }

    @PutMapping("/posts/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post post) {
        post.setId(id);
        return postService.updatePost(post);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable Long id) {

        postService.deletePost(id);
    }

    @GetMapping("/users/{userId}/posts")
    public List<Post> getPostsByUserId(@PathVariable Long userId) {
        return postService.getPostsByUserId(userId);
    }
}
