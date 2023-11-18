package com.vti.Part_time_Job.repository;

import com.vti.Part_time_Job.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepository extends JpaRepository<Comment, Integer>  {
}
