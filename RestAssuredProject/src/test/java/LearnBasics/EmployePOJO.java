package LearnBasics;

import java.util.Arrays;

public class EmployePOJO {

    private String name;
    private String job;
    private String[] skills;
    private DetailsPOJO details;

    public EmployePOJO() {


    }

    //IMPORTANT adding 2nd class variables and assigning thru NEW keyword*********************
    public EmployePOJO(String name, String job, String[] skills, String companyName, String emailId) {

        this.name = name;
        this.job = job;
        this.skills = skills;
        this.details = new DetailsPOJO(companyName, emailId);  //IMPORTANT new Key word and calling constructor *********************
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String[] getSkills() {
        return skills;
    }

    public DetailsPOJO getdetails() {
        return details;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    public void setDelails(DetailsPOJO details) {
        this.details = details;
    }


    @Override
    public String toString() {
        return "EmployeePOJO [name=" + name + ", job=" + job + ", skills=" + Arrays.toString(skills) + ", details="
                + details + "]";
    }
}
