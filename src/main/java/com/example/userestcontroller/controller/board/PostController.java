package com.example.userestcontroller.controller.board;

import com.example.userestcontroller.model.board.Post;
import com.example.userestcontroller.service.board.PostService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/posts")
@CrossOrigin(origins = "http://localhost:8181")
public class PostController {

    @Setter(onMethod_ = {@Autowired})
    private PostService postService;

    @GetMapping
    public List<Post> getAllPosts() {

        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {

        return postService.getPostById(id);
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post post) {
        post.setId(id);
        return postService.updatePost(post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
