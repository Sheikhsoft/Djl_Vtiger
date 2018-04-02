package vtiger.djl.william.djl_vtiger.network.ws;

import vtiger.djl.william.djl_vtiger.network.EasyHomeAPI;

/**
 * Created by William on 24/03/2018.
 */

public class ApiUtils {
    private ApiUtils() {
    }

    public static final String BASE_URL = "http://www.djlpuntodot.com/crm/";

    public static EasyHomeAPI getAPIService() {
        return RetrofitClient.getClient(BASE_URL).create(EasyHomeAPI.class);
    }
}
