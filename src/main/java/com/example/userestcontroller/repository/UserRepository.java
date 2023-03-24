package com.example.userestcontroller.repository;

import com.example.userestcontroller.model.board.Post;
import com.example.userestcontroller.model.board.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository  extends JpaRepository<User, Long> {
}
