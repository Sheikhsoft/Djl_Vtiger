package vtiger.djl.william.djl_vtiger.API;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vtiger.djl.william.djl_vtiger.API.Deserializers.LoginDeserializer;
import vtiger.djl.william.djl_vtiger.API.Deserializers.ProjectDeserializer;
import vtiger.djl.william.djl_vtiger.Models.Projects;
import vtiger.djl.william.djl_vtiger.Models.ProjectsList;
import vtiger.djl.william.djl_vtiger.Models.Users;

/**
 * Created by William on 20/03/2018.
 */

public class API {
    public static final String BASE_URL = "http://www.djlpuntodot.com/crm/";

    private static Retrofit retrofit = null;
    private static Retrofit retrofitProject = null;

    public static Retrofit getApi(){
        if (retrofit == null){
            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(Users.class, new LoginDeserializer());

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(builder.create()))
                    .build();
        }
        return retrofit;
    }

    public static Retrofit getProjectsApi(){
        if (retrofitProject == null){
            /*GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(ProjectsList.class, new ProjectDeserializer());*/
            //SE QUITO LA DESEREALIZACION
            retrofitProject = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitProject;
    }

    //RESULTADO DEL JSON
    /*
    [
        {
            "projectid": "5",
            "projectname": "market force",
            "projectstatus": "completed",
            "accountid": "2",
            "accountname": "auna"
        },
        {
            "projectid": "58",
            "projectname": "Facturacion electronica",
            "projectstatus": "prospecting",
            "accountid": "2",
            "accountname": "auna"
        },
        {
            "projectid": "62",
            "projectname": "GDC-2018-0008 - MODIFICACIÓN TRAMA DE AFILIACIÓN VISANET",
            "projectstatus": "in progress",
            "accountid": "2",
            "accountname": "auna"
        },
        {
            "projectid": "40",
            "projectname": "App envio de dinero",
            "projectstatus": "initiated",
            "accountid": "38",
            "accountname": "IBM"
        },
        {
            "projectid": "46",
            "projectname": "App banco",
            "projectstatus": "initiated",
            "accountid": "44",
            "accountname": "BCP"
        },
        {
            "projectid": "7",
            "projectname": "Vtiger Web / Android App",
            "projectstatus": "initiated",
            "accountid": "",
            "accountname": ""
        },
        {
            "projectid": "24",
            "projectname": "Prueba",
            "projectstatus": "",
            "accountid": "",
            "accountname": ""
        }
    ]
     */

}
