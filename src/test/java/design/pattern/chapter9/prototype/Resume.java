package design.pattern.chapter9.prototype;

import org.apache.log4j.Logger;

/**
 * Created by h on 2017/9/24.
 */
public class Resume implements Cloneable {
    private static final Logger logger = Logger.getLogger(Resume.class);
    private String name;
    private String gender;
    private int age;
    private WorkExperience workExperience;
    private Resume() {}
    public Resume(String name) {
        this.name = name;
        this.workExperience = new WorkExperience();
    }

    private Resume(WorkExperience workExperience) throws CloneNotSupportedException {
        this.workExperience = (WorkExperience) workExperience.clone();
    }

    public void setPersonInfo(String gender, int age) {
        this.gender = gender;
        this.age = age;
    }

    public void setWorkExperience(String workDate, String company) {
        workExperience.setWordDate(workDate);
        workExperience.setCompany(company);
    }

    public void display() {
        logger.info(String.format("\n 个人信息：%s %s %s \n 工作经历：%s %s",
                this.name, this.gender, this.age,
                this.workExperience.getWordDate(), this.workExperience.getCompany()));
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // test1
//        return super.clone();
        // test2
        Resume resume = new Resume(this.workExperience);
        resume.name = this.name;
        resume.gender = this.gender;
        resume.age = this.age;
        return resume;
    }
}
