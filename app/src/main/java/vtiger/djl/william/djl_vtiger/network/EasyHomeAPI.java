package vtiger.djl.william.djl_vtiger.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import vtiger.djl.william.djl_vtiger.network.response.getProjectsResponse;

/**
 * Created by William on 24/03/2018.
 */

public interface EasyHomeAPI {
    @GET("vtiger_projectList.php")
    Call<List<getProjectsResponse>> listProjects();
}
