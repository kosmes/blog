package com.jineyne.blog.controller.api;

import com.jineyne.blog.dao.PostDao;
import com.jineyne.blog.model.PostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostApiController {
    @Autowired
    PostDao postDao;

    @GetMapping
    List<PostModel> getPosts() {
        return postDao.findAll();
    }

    @PostMapping
    PostModel createPost(@RequestBody PostModel m) {
        m.setRegDate(new Date());
        return postDao.save(m);
    }

    @PutMapping("/{id}")
    PostModel updatePost(@RequestBody PostModel m, @PathVariable int id) {
        return postDao.findById(id)
                .map((post) -> {
                    post.setTitle(m.getTitle());
                    post.setContent(m.getContent());
                    post.setRegDate(new Date());
                    return postDao.save(post);
                }).orElseGet(() -> {
                    m.setId(id);
                    return postDao.save(m);
                });
    }

    @DeleteMapping("/{id}")
    void removePost(@PathVariable int id) {
        postDao.deleteById(id);
    }
}
