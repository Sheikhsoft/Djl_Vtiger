package vtiger.djl.william.djl_vtiger.Utils;

import android.content.SharedPreferences;

/**
 * Created by William on 13/03/2018.
 */

public class Util {

    public static String getIdPrefs(SharedPreferences preferences) {
        return preferences.getString("id", "");
    }

    public static String getSessionPrefs(SharedPreferences preferences) {
        return preferences.getString("sesion", "");
    }

    public static String getChechBoxPrefs(SharedPreferences preferences) {
        return preferences.getString("remember", "");
    }

    public static String getUserPrefs(SharedPreferences preferences) {
        return preferences.getString("user", "");
    }

    public static String getPassPrefs(SharedPreferences preferences) {
        return preferences.getString("pass", "");
    }

    public static String getNamePrefs(SharedPreferences preferences) {
        return preferences.getString("nom", "");
    }

    public static String getSurnamePrefs(SharedPreferences preferences) {
        return preferences.getString("ape", "");
    }

    public static void removeSharedPreferences(SharedPreferences preferences) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove("user");
        editor.remove("pass");
        editor.remove("sesion");
        editor.apply();
    }

    /*public static String rutaWs_login = "http://www.djlpuntodot.com/crm/prueba.php";
    public static String rutaWS_projectList = "http://www.djlpuntodot.com/crm/vtiger_projectList.php";*/
}
