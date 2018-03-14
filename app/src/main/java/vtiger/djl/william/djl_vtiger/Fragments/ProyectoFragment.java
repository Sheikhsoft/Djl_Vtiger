package vtiger.djl.william.djl_vtiger.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vtiger.djl.william.djl_vtiger.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProyectoFragment extends Fragment {


    public ProyectoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_proyecto, container, false);
    }

}
