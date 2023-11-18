package com.vti.Part_time_Job.service;

import com.vti.Part_time_Job.entity.Comment;
import com.vti.Part_time_Job.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommentService {
    @Autowired
    private ICommentRepository repository ;

    @Override
    public List<Comment> findAll(){
        return repository.findAll() ;
    }

    @Override
    public Comment findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void create(Comment form) {
        repository.save(form) ;
    }

    @Override
    public void update(Comment form) {
        repository.save(form) ;
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAllById(List<Integer> ids) {
        repository.deleteAllById(ids);
    }
}
