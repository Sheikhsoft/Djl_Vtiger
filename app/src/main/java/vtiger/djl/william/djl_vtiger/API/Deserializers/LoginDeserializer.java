package vtiger.djl.william.djl_vtiger.API.Deserializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import vtiger.djl.william.djl_vtiger.Models.Users;

/**
 * Created by William on 20/03/2018.
 */

public class LoginDeserializer implements JsonDeserializer<Users>{

    @Override
    public Users deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        int id = json.getAsJsonArray().get(0).getAsJsonObject().get("id").getAsInt();
        String usuario = json.getAsJsonArray().get(0).getAsJsonObject().get("user_name").getAsString();
        String nombre = json.getAsJsonArray().get(0).getAsJsonObject().get("first_name").getAsString();
        String apellido = json.getAsJsonArray().get(0).getAsJsonObject().get("last_name").getAsString();

        Users users = new Users(id, usuario, nombre,apellido);
        return users;
    }
}
