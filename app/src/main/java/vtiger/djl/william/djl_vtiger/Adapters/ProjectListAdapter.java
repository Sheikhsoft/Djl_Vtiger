package vtiger.djl.william.djl_vtiger.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vtiger.djl.william.djl_vtiger.Interfaces.ProjectItemClickListener;
import vtiger.djl.william.djl_vtiger.Models.Projects;
import vtiger.djl.william.djl_vtiger.R;

/**
 * Created by William on 15/03/2018.
 */

public class ProjectListAdapter extends RecyclerView.Adapter<ProjectListAdapter.ViewHolder>{
    private Context mContext;
    private List<Projects> projects;
    private ProjectItemClickListener projectListener;

    public ProjectListAdapter(Context context,List<Projects> projects, ProjectItemClickListener listener) {
        this.projects = projects;
        this.mContext = context;
        this.projectListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_projects, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(projects.get(position), projectListener);
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

        public void bind(final Projects project, final ProjectItemClickListener listener){
            this.mtvProjectName.setText(project.getProjectname());
            this.mtvProjectAccount.setText(project.getAccountname());
            this.mtvProjectStatus.setText(project.getProjectstatus());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(project,getAdapterPosition());
                }
            });
        }
    }
}
