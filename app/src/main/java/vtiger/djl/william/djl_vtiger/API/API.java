package vtiger.djl.william.djl_vtiger.API;

import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vtiger.djl.william.djl_vtiger.API.Deserializers.LoginDeserializer;
import vtiger.djl.william.djl_vtiger.Models.Users;

/**
 * Created by William on 20/03/2018.
 */

public class API {
    public static final String BASE_URL = "http://www.djlpuntodot.com/crm/";

    private static Retrofit retrofit = null;

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
}
