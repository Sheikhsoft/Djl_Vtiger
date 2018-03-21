package vtiger.djl.william.djl_vtiger.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by William on 20/03/2018.
 */

public class Users {

    private int id;
    private String user_name;
    private String first_name;
    private String last_name;
    private String email1;
    private String phone_home;
    private String phone_mobile;
    private String phone_work;

    public Users() {
    }

    public Users(int id, String user_name, String first_name, String last_name) {
        this.id = id;
        this.user_name = user_name;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
