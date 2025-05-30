Springboot Job Portal Project.

--> Recruiters can create a new jobs
--> Job Candidates can search for new jobs and apply 

----------------------------------
Dev tools: 
--> Intellij
--> MySQL Database server
--> MySQL Workbench

----------------------------------
Requirements - Recruiter
--> Post new job
--> View our jobs 
--> View list of Candidates that have applied for a job 
--> Edit profile and upload profile photo 

Requirements - Candidate
--> Search for a job
--> Apply for a job 
--> View list of jobs that you(job candidate) has applied for 
--> Edit profile and upload the profile photo
--> upload resume /cv


Requirements for common 
--> Register for new account (DONE)
--> Login/LogOut 

---------------------------------
Application Architecture:

web browser ---> Controller(handle web requestS)  <----->  service(businsess logic)  <----> Repository(database access) <----> DB
       ^             |
	   |			 |
	   |             |
       | <----- Thymeleaf Templates(the view user interface)
	  
---------------------------------------
Key Classes:

HomeController/Service/Repository : Show Home Page

JobLocationContoller/Service/Repository : Manging job locations

JobPostActivityContoller/Service/Repository : Manging job posts and searching job posts

JobSeekerApplyContoller/Service/Repository  : Applying for jobs 

JobSeskerProfileController/Service/Repository : Manging job seeker profile 

JobSeekerSaveController/Service/Repository : Manging jobs that job seeker has applied for 

RecruiterProfileController/Service/Repository : Manging recuiter profile

UsersController/Service/Repository : Login/logout/Register

---------------------------------------------
Database Entities 

JobCompany : A job company, name , logo etc..,
JobPostActivity : A job post, title, description, salary, remote etc..,
JobSeekerApply : Tracks the jonb seekers who have applied for a job 
JobSeekerProfile : Info about job seeker, name, city,state, skills etc..,
Jobseekersave : tracks the jobs a seeker has applied to 
RecruiterProfile : Info about recuiter, name, city, state, company, etc..,
skills: info about a skill: name, experience level , years of experience
Users: Info about a user : email , password etc.., 
UsersType : Type/role of user : recruiter or job seeker

------------------------------------------
Database Diagram 

------------------------------------------
Development Road Map

1 User Registration

  login in/ out -------> RecruiterProfile            candidate PROFILE
  
                           
						RecruiterDashboard           Candidate DASHBOARD
						
						Recruiter - new JOB          Candidate APPLY 
						
------------------------------------------

Two Database Scripts 
1. Folder : starter-sql-scripts
            --> create-user.sql 
			--> jobportal.sql
		
	create a new MYSQL user for our application 
	--> user id : jobportal
	--> password : jobportal 
	
	
---------------------------------------------
Development process
1.setup springboot project (done

2. add project template files (HTML , CSS & JS) (done)
--> we can use webjars for the project
. bootstrap :- CSS framework for HTML page layout /positioning
. jquery :- javascript framework for HTML page processing
. font-awesome :- collection of fonts, icons & images
. webjars-locator :-  Support files for locating assets in jar files

3. Database Entities for users, UsersTypes (DONE)
. Users :- basic information about a user
. UserType :- a user role

One-TO-Many Mapping
->  A UserType can have many users
  . Bi  directional 
  
Many-To-One Mapping
-> Many users can have one user type
   . Inverse/opposite of one to many 
   
-> create a JPA/Hibernate database Entities
   . Users: basic information about a user
   . UserType: a user role 
   
 --> Add Maven dependency 
    . spring data jpa
	. MYSQL JDBC driver
	. validation
	. dev tools 
	
4. User Registration : Repositories and controller (DONE)
5. Create Profiles for Recruiter and Job Seekers
6. Add support for skills to job seekers


7. Duplicate Email :
--> Reproduce the bug
--> Add a new method to repository and service : find a user by email 
--> update controller:
    . during registration , check if email before registering user
	.if email exists, add error message to model and return to registration form 
--> update the registratin form to show error message

 profiles for recruiter and candidates:
 --> create JPA repository 
 --> job seeker profile
 --> recruiter profile
 --> skills
 
 profile : One To One Mapping
 A recruiter profile is associated with one user
 A jobseeker profile is associated with one user
 
 Skills : one TO Many Mapping
 
-----------------------------
log in / log out :

1. Add spring security maven dependency
2. Configure spring security
3. Develop custom user authentication and authorizartion 
4. create custom authentication success handler
5. Integrate dashboard with current logged in user
6. Add login /logout request mapping to the controller


password :  16027550-7fc8-46d1-8093-df8314522fde 

-------------------------------
recruiter profile
1. create recruiter profile -controller and service
2. add support for file upload of recruiter profile images
3. update the dashboard to display the recruiter profile images

--------------------------------

recruiter post new job:

1. create JPA entities : JOB location , job company, jobpostactivity
2. jobpostactivitycontroller : enchance for posting a new job
3. Integrate HTML form for posting a job

JPA entities:
. job location : city, country, state
. job company : name, logo 
.jobpostactivity : title, description

-------------------------------
recruiter DASHBOARD:
1. Enhance dashboard.html to display  a list of jobs on the board
2. update jobpostactivitycontroller : retrive list of jobs for logged in recruiter
3. Add support to show job details 

----------------------------
candidate dashboard:
1. update entity : jobseekerprofile
2. create jobseekerprofile -  controller and service
3. Add support for file upload jobseeker profile image and resume

----------------------------
candidate dashboard and apply:
candidate dashboard and save job

1.create JObseekerApply entity 
2.create JobSeekerSave entity
3. update controller for searching and applying for job
4. add support to save jobs for a candidate

Database Entities
.jobseeker apply
.jobseeker save

JobSeekerApply : Many to One mapping
. a jobseeker apply is mapped many to one

JobSeekerSave : Many to one mapping
. a jobseekersave is mapped many to one



Implementation Steps :

--> created a home page
--> able to register as a jobseeker or recuirter
--> email duplication..
--> Create the profiles for recruiter and candidates


sunil@gmail.com   recruiter

gulli@gmail.com  jobseeker