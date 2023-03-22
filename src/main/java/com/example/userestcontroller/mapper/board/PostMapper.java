//package com.example.userestcontroller.mapper.board;
//
//import com.example.userestcontroller.model.board.Post;
//import org.apache.ibatis.annotations.*;
//
//import java.util.List;
//
//@Mapper
//public interface PostMapper {
//
//    @Select("SELECT * FROM posts")
//    List<Post> findAll();
//
//    @Select("SELECT * FROM posts WHERE id = #{id}")
//    Post findById(@Param("id") Long id);
//
//    @Insert("INSERT INTO posts(title, content) VALUES(#{title}, #{content})")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
//    void save(Post post);
//
//    @Update("UPDATE posts SET title = #{title}, content = #{content} WHERE id = #{id}")
//    void update(Post post);
//
//    @Delete("DELETE FROM posts WHERE id = #{id}")
//    void delete(@Param("id") Long id);
//}
