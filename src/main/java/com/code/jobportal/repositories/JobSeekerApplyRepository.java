package com.code.jobportal.repositories;

import com.code.jobportal.Entity.JobPostActivity;
import com.code.jobportal.Entity.JobSeekerApply;
import com.code.jobportal.Entity.JobSeekerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSeekerApplyRepository extends JpaRepository<JobSeekerApply, Integer> {

    List<JobSeekerApply> findByUserId(JobSeekerProfile userId);

    List<JobSeekerApply> findByJob(JobPostActivity job);
}