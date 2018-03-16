package vtiger.djl.william.djl_vtiger.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import vtiger.djl.william.djl_vtiger.Adapters.ProjectList_Adapter;
import vtiger.djl.william.djl_vtiger.R;
import vtiger.djl.william.djl_vtiger.Utils.Util;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProyectoFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    public ProyectoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_proyecto, container, false);
        mRecyclerView = view.findViewById(R.id.rvProjects);
        mLayoutManager = new LinearLayoutManager(getContext());
        listProjects();
        // Inflate the layout for this fragment
        return view;
    }

    private void listProjects(){
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

            ProjectList_Adapter projectListAdapter = new ProjectList_Adapter(arrayList,R.layout.recycler_view_projects);
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

    }

}
