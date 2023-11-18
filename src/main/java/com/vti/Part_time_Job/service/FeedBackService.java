package com.vti.Part_time_Job.service;


import com.vti.Part_time_Job.entity.FeedBack;
import com.vti.Part_time_Job.repository.IFeedBackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedBackService implements IFeedBackService {
    @Autowired
    private IFeedBackRepository repository ;
    @Override
    public List<FeedBack> findAll(){
        return repository.findAll() ;
    }

    @Override
    public FeedBack findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void create(FeedBack form) {
        repository.save(form) ;
    }

    @Override
    public void update(FeedBack form) {
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
