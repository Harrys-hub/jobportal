package com.code.jobportal.services;

import com.code.jobportal.Entity.JobPostActivity;
import com.code.jobportal.repositories.JobPostActivityRepository;
import org.springframework.stereotype.Service;

@Service
public class JobPostActivityService {


    private  final JobPostActivityRepository jobPostActivityRepository;

    public JobPostActivityService(JobPostActivityRepository jobPostActivityRepository) {
        this.jobPostActivityRepository = jobPostActivityRepository;
    }

    public JobPostActivity addNew(JobPostActivity jobPostActivity){
        return jobPostActivityRepository.save(jobPostActivity);

    }

}
