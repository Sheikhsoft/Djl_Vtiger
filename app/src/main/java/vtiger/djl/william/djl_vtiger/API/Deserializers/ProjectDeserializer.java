package vtiger.djl.william.djl_vtiger.API.Deserializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import vtiger.djl.william.djl_vtiger.Models.Projects;

/**
 * Created by William on 21/03/2018.
 */

public class ProjectDeserializer implements JsonDeserializer<List<Projects>> {

    private List<Projects> arrayList = new ArrayList<>();

    @Override
    public List<Projects> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        for (int i = 0 ; i <= json.getAsJsonArray().size()-1; i++){
            String id = json.getAsJsonArray().get(i).getAsJsonObject().get("projectid").getAsString();
            String name = json.getAsJsonArray().get(i).getAsJsonObject().get("projectname").getAsString();
            String status = json.getAsJsonArray().get(i).getAsJsonObject().get("projectstatus").getAsString();
            String accountid = json.getAsJsonArray().get(i).getAsJsonObject().get("accountid").getAsString();
            String account = json.getAsJsonArray().get(i).getAsJsonObject().get("accountname").getAsString();
            Projects projects = new Projects(id,name,status,accountid,account);
            arrayList.add(projects);
        }
        return arrayList;
    }





    /*
        private List<Projects> arrayList = new ArrayList<>();


    @Override
    public List<Projects> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        for (int i = 0 ; i <= json.getAsJsonArray().size()-1; i++){
            int id = json.getAsJsonArray().get(i).getAsJsonObject().get("projectid").getAsInt();
            String name = json.getAsJsonArray().get(i).getAsJsonObject().get("projectname").getAsString();
            String status = json.getAsJsonArray().get(i).getAsJsonObject().get("projectstatus").getAsString();
            int accountid = json.getAsJsonArray().get(i).getAsJsonObject().get("accountid").getAsInt();
            String account = json.getAsJsonArray().get(i).getAsJsonObject().get("accountname").getAsString();
            /*projects.setProjectid(json.getAsJsonArray().get(i).getAsJsonObject().get("projectid").getAsInt());
            projects.setProjectname(json.getAsJsonArray().get(i).getAsJsonObject().get("projectname").getAsString());
            projects.setProjectstatus(json.getAsJsonArray().get(i).getAsJsonObject().get("projectstatus").getAsString());
            projects.setAccountid(json.getAsJsonArray().get(i).getAsJsonObject().get("accountid").getAsInt());
            projects.setAccountname(json.getAsJsonArray().get(i).getAsJsonObject().get("accountname").getAsString());
            Projects projects = new Projects(id,name,status,accountid,account);
            arrayList.add(projects);

        return arrayList;
     */
}
