package vtiger.djl.william.djl_vtiger.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.w3c.dom.ls.LSInput;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vtiger.djl.william.djl_vtiger.API.API;
import vtiger.djl.william.djl_vtiger.API.APIServices.Services;
import vtiger.djl.william.djl_vtiger.Adapters.ProjectListAdapter;
import vtiger.djl.william.djl_vtiger.Models.Projects;
import vtiger.djl.william.djl_vtiger.Models.ProjectsList;
import vtiger.djl.william.djl_vtiger.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProyectoFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ProjectListAdapter projectListAdapter;

    private Services service;
    private Call<ProjectsList> projectsCall;

    public ProyectoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_proyecto, container, false);
        //ADAPTADOR ESTA COMENTADO HASTA QUE EL DEBUG DEVUELVA EL RESPONSE CORRECTO
        /*mRecyclerView = view.findViewById(R.id.rvProjects);
        mLayoutManager = new LinearLayoutManager(getContext());*/
        service = API.getProjectsApi().create(Services.class);
        projectsCall = service.listProjects();
        projectsCall.enqueue(new Callback<ProjectsList>() {
            @Override
            public void onResponse(Call<ProjectsList> call, Response<ProjectsList> response) {
                List<Projects> list = response.body().getProjectsArrayList();
                Toast.makeText(getActivity().getApplicationContext(),list.get(0).getProjectname(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ProjectsList> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(),"Error: " + t.toString(), Toast.LENGTH_LONG).show();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }


    //METODO COMENTADO CONEXION FUNCIONA PERO SE DESEA USAR RETROFIT EN EL PROYECTO
     /*private void listProjects(){

       String ruta = Util.rutaWS_projectList;
        URL url;

        try {
            url = new URL(ruta);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setRequestMethod("GET");

            InputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            JSONArray jsonArray = new JSONArray(bufferedReader.readLine());
            final ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
            for(int i=0; i<= jsonArray.length()-1; i++){
                HashMap<String, String> map = new HashMap<>();
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                map.put("pjName", jsonObject.getString("projectname"));
                map.put("pjContact", jsonObject.getString("accountname"));
                map.put("pjStatus", jsonObject.getString("projectstatus"));

                arrayList.add(map);
            }

            ProjectListAdapter projectListAdapter = new ProjectListAdapter(arrayList,R.layout.recycler_view_projects);
            mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(projectListAdapter);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }*/

}
