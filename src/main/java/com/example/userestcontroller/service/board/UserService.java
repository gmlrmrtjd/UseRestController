package com.example.userestcontroller.service.board;

import com.example.userestcontroller.model.board.Post;
import com.example.userestcontroller.model.board.User;
import com.example.userestcontroller.repository.UserRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    @Setter(onMethod_ = {@Autowired})
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    public User updateUser(Long userId, User user) {
        User updatedUser = userRepository.findById(userId).orElse(new User());

            updatedUser.setUsername(user.getUsername());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setName(user.getName());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setCreatedAt(updatedUser.getCreatedAt());
            updatedUser.setCreatedAt(LocalDateTime.now());

            return userRepository.save(updatedUser);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public List<Post> getPostsByUserId(Long userId) {
        User user = Objects.requireNonNull(userRepository.findById(userId).orElse(null));
        return user.getPosts();
    }

}
