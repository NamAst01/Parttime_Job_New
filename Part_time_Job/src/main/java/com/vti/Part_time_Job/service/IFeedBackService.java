package com.vti.Part_time_Job.service;

import com.vti.Part_time_Job.entity.FeedBack;

import java.util.List;

public interface IFeedBackService {
    List<FeedBack> findAll();

    FeedBack findById(Integer id);

    void create(FeedBack form);

    void update(FeedBack form);

    void deleteById(Integer id);

    void deleteAllById(List<Integer> ids);
}
