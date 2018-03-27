package vtiger.djl.william.djl_vtiger.Adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vtiger.djl.william.djl_vtiger.Models.Dashboard;
import vtiger.djl.william.djl_vtiger.R;

/**
 * Created by William on 21/03/2018.
 */

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.ViewHolder>{

    private List<Dashboard> list;
    private int layout;

    public DashboardAdapter(List<Dashboard> list, int layout) {
        this.list = list;
        this.layout = layout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item_dashboard, parent, false);
        //context = parent.getContext();
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        //Elementos GUI
        public TextView mtvNumberItem;
        public TextView mtvItemDashboard;
        public ImageView mivIcon;

        public ViewHolder(View itemView) {
            super(itemView);
            this.mtvNumberItem = itemView.findViewById(R.id.tvNumberItem);
            this.mtvItemDashboard = itemView.findViewById(R.id.tvItemDashboard);
            this.mivIcon = itemView.findViewById(R.id.ivIcon);
        }

        public void bind(final Dashboard dashboard){
            this.mtvNumberItem.setText(String.valueOf(dashboard.getNumber()));
            //this.mtvItemDashboard.setText(dashboard.getItem());
            //Falta el icono
        }
    }
}
