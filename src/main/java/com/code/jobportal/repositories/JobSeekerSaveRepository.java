package com.code.jobportal.repositories;


import com.code.jobportal.Entity.JobPostActivity;
import com.code.jobportal.Entity.JobSeekerProfile;
import com.code.jobportal.Entity.JobSeekerSave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSeekerSaveRepository extends JpaRepository<JobSeekerSave, Integer> {

    public List<JobSeekerSave> findByUserId(JobSeekerProfile userAccountId);

    List<JobSeekerSave> findByJob(JobPostActivity job);

}