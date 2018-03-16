package vtiger.djl.william.djl_vtiger.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import vtiger.djl.william.djl_vtiger.R;

/**
 * Created by William on 15/03/2018.
 */

public class ProjectList_Adapter extends RecyclerView.Adapter<ProjectList_Adapter.ViewHolder>{
    private ArrayList projects;
    private int layout;

    public ProjectList_Adapter(ArrayList projects, int layout) {
        this.projects = projects;
        this.layout = layout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HashMap<String,String> map = (HashMap<String, String>) projects.get(position);
        holder.bind(map.get("pjName").toString(), map.get("pjContact").toString(), map.get("pjStatus").toString());
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView mtvProjectName;
        private TextView mtvProjectAccount;
        private TextView mtvProjectStatus;

        public ViewHolder(View itemView) {
            super(itemView);

            this.mtvProjectName = itemView.findViewById(R.id.tvProjectName);
            this.mtvProjectAccount = itemView.findViewById(R.id.tvProjectAccount);
            this.mtvProjectStatus = itemView.findViewById(R.id.tvProjectStatus);
        }

        public void bind(final String projectName, final String projectAccount, final String projectStatus){
            this.mtvProjectName.setText(projectName);
            this.mtvProjectAccount.setText(projectAccount);
            this.mtvProjectStatus.setText(projectStatus);
        }
    }
}
