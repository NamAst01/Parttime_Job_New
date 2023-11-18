package com.vti.Part_time_Job.service;

import com.vti.Part_time_Job.entity.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> findAll();

    Comment findById(Integer id);

    void create(Comment form);

    void update(Comment form);

    void deleteById(Integer id);

    void deleteAllById(List<Integer> ids);
}
