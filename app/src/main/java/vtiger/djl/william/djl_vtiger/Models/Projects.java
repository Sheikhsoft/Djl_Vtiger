package vtiger.djl.william.djl_vtiger.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by William on 21/03/2018.
 */

public class Projects {
    @SerializedName("projectid")
    private int projectid;
    @SerializedName("projectname")
    private String projectname;
    private String project_no;
    private String stardate;
    private String targetenddate;
    private String actualenddate;
    private String projecturl;
    @SerializedName("projectstatus")
    private String projectstatus;
    private String projectpriority;
    private String progress;
    private int linktoaccountscontacts;
    private int isconvertedfrompotencial;
    private int potencialid;

    //FK account
    @SerializedName("accountid")
    private int accountid;
    @SerializedName("accountname")
    private String accountname;

    public Projects() {
    }

    public Projects(int projectid, String project_name, String projectstatus, int accountid, String accountname) {
        this.projectid = projectid;
        this.projectname = project_name;
        this.projectstatus = projectstatus;
        this.accountid = accountid;
        this.accountname = accountname;
    }

    public int getProjectid() {
        return projectid;
    }

    public void setProjectid(int projectid) {
        this.projectid = projectid;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String project_name) {
        this.projectname = project_name;
    }

    public String getProjectstatus() {
        return projectstatus;
    }

    public void setProjectstatus(String projectstatus) {
        this.projectstatus = projectstatus;
    }

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }
}
