package vtiger.djl.william.djl_vtiger.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import vtiger.djl.william.djl_vtiger.Adapters.DashboardAdapter;
import vtiger.djl.william.djl_vtiger.Models.Dashboard;
import vtiger.djl.william.djl_vtiger.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashBoardFragment extends Fragment {
    private List<Dashboard> dashboard;
    private RecyclerView mrvDashboard;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public DashBoardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dash_board, container, false);
        /*dashboard = this.getDashboard();
        mrvDashboard = v.findViewById(R.id.rvDashboard);
        mLayoutManager = new GridLayoutManager(this.getActivity(),2);
        mAdapter = new DashboardAdapter(dashboard,R.layout.recycler_view_item_dashboard);
        mrvDashboard.setLayoutManager(mLayoutManager);
        mrvDashboard.setAdapter(mAdapter);*/
        // Inflate the layout for this fragment
        return v;
    }

    private List<Dashboard> getDashboard() {
        return new ArrayList<Dashboard>() {{
            add(new Dashboard(10, "Proyectos","img"));
            add(new Dashboard(5, "Cuentas", "img"));
            add(new Dashboard(15, "Contactos","img"));
            add(new Dashboard(8, "Oportunidades","img"));
        }};
    }

}
