package design.pattern.chapter9.prototype;

/**
 * Created by h on 2017/9/24.
 */
public class WorkExperience implements Cloneable {
    private String wordDate;
    private String company;
    public WorkExperience() {}
    public WorkExperience(String wordDate, String company) {
        this.wordDate = wordDate;
        this.company = company;
    }

    public String getWordDate() {
        return wordDate;
    }

    public void setWordDate(String wordDate) {
        this.wordDate = wordDate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
