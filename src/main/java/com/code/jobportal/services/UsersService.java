package com.code.jobportal.services;


import com.code.jobportal.Entity.JobSeekerProfile;
import com.code.jobportal.Entity.RecruiterProfile;
import com.code.jobportal.Entity.Users;
import com.code.jobportal.repositories.JobSeekerProfileRepository;
import com.code.jobportal.repositories.RecruiterProfileRepository;
import com.code.jobportal.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.Optional;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final JobSeekerProfileRepository jobSeekerProfileRepository;
    private final RecruiterProfileRepository  recruiterProfileRepository;


    @Autowired
    public UsersService(UsersRepository usersRepository,
                        JobSeekerProfileRepository jobSeekerProfileRepository,
                        RecruiterProfileRepository  recruiterProfileRepository) {
        this.usersRepository =usersRepository;
        this.recruiterProfileRepository = recruiterProfileRepository;
        this.jobSeekerProfileRepository = jobSeekerProfileRepository;
    }

    public Users addNew(Users users){
        users.setActive(true);
        users.setRegistrationDate(new Date(System.currentTimeMillis()));
        Users saveduser= usersRepository.save(users);
        int userTypeId = users.getUserTypeId().getUserTypeId();
        if(userTypeId==1){
            recruiterProfileRepository.save(new RecruiterProfile(saveduser));
        }
        else{
            jobSeekerProfileRepository.save(new JobSeekerProfile(saveduser));
        }
        return saveduser;
    }

    public Optional<Users> getUserByEmail(String email){
        return  usersRepository.findByEmail(email);
    }
}
