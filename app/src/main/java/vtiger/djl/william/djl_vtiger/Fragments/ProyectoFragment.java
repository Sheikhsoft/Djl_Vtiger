package vtiger.djl.william.djl_vtiger.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vtiger.djl.william.djl_vtiger.API.API;
import vtiger.djl.william.djl_vtiger.API.APIServices.Services;
import vtiger.djl.william.djl_vtiger.Activities.MainActivity;
import vtiger.djl.william.djl_vtiger.Activities.ProjectActivity;
import vtiger.djl.william.djl_vtiger.Adapters.ProjectListAdapter;
import vtiger.djl.william.djl_vtiger.Interfaces.ProjectItemClickListener;
import vtiger.djl.william.djl_vtiger.Models.Projects;
import vtiger.djl.william.djl_vtiger.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProyectoFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ProjectListAdapter projectListAdapter;
    //EasyHomeAPI goEasyHomeAPI;

    private Services service;
    private Call<List<Projects>> projectsCall;
    private List<Projects> projectList;

    public ProyectoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_proyecto, container, false);
        //ADAPTADOR ESTA COMENTADO HASTA QUE EL DEBUG DEVUELVA EL RESPONSE CORRECTO
        mRecyclerView = view.findViewById(R.id.rvProjects);
        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        //service = API.getProjectsApi().create(Services.class);
        /* METODO CLASICO UDEMY */
        service = API.getProjectsApi().create(Services.class);
        projectsCall = service.listProjects();
        listarAntiguo();
        //projectsCall.enqueue();
        // Inflate the layout for this fragment
        /* METODO DE HERNAN */
        //goEasyHomeAPI = ApiUtils.getAPIService();
        //listarProjects();
        return view;
    }

    private void listarAntiguo(){
        projectsCall.enqueue(new Callback<List<Projects>>() {
            @Override
            public void onResponse(Call<List<Projects>> call, Response<List<Projects>> response) {
                projectList = new ArrayList<>();
                projectList.clear();
                projectList.addAll(response.body());
                projectListAdapter = new ProjectListAdapter(getActivity().getApplicationContext(), response.body(), new ProjectItemClickListener() {
                    @Override
                    public void onItemClick(Projects project, int position) {
                        Intent intent = new Intent(getActivity(), ProjectActivity.class);
                        startActivity(intent);
                    }
                });
                mRecyclerView.setHasFixedSize(true);
                mRecyclerView.setLayoutManager(mLayoutManager);
                mRecyclerView.setAdapter(projectListAdapter);
                //Toast.makeText(getActivity().getApplicationContext(), "List<getProjectsResponse>: " + response.body().size(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Projects>> call, Throwable t) {
                Toast.makeText(getActivity().getApplicationContext(), "Error: "+t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*
    private void listarProjects(){
        goEasyHomeAPI.listProjects().enqueue(new Callback<List<getProjectsResponse>>() {
            @Override
            public void onResponse(Call<List<getProjectsResponse>> call, Response<List<getProjectsResponse>> response) {
                Toast.makeText(getActivity().getApplicationContext(), "List<getProjectsResponse>: " + response.body().size(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<getProjectsResponse>> call, Throwable t) {
                Toast.makeText(getActivity().getApplicationContext(), "Error: "+t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }*/


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
