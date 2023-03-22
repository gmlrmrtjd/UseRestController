package com.example.userestcontroller.repository;

import com.example.userestcontroller.model.board.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
