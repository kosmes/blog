package com.jineyne.blog.dao;

import com.jineyne.blog.model.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDao extends JpaRepository<PostModel, Integer> {
}
