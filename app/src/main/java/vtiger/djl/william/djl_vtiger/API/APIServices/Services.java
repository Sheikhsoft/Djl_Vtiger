package vtiger.djl.william.djl_vtiger.API.APIServices;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import vtiger.djl.william.djl_vtiger.Models.Projects;
import vtiger.djl.william.djl_vtiger.Models.Users;

/**
 * Created by William on 20/03/2018.
 */

public interface Services {

    @GET("prueba.php")
    Call<Users> getLogin(@Query("user") String user, @Query("pass") String pass);

    @GET("vtiger_projectList.php")
    Call<List<Projects>> listProjects();
}
