package vtiger.djl.william.djl_vtiger.Utils;

import android.content.SharedPreferences;

/**
 * Created by William on 13/03/2018.
 */

public class Util {

    public static String getSesionPrefs(SharedPreferences preferences) {
        return preferences.getString("sesion", "0");
    }
    public static String rutaWs_login = "http://www.djlpuntodot.com/crm/prueba.php";
}
