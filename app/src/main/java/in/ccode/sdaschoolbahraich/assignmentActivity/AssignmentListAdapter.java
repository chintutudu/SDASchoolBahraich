package in.ccode.sdaschoolbahraich.assignmentActivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import in.ccode.sdaschoolbahraich.R;


public class AssignmentListAdapter extends RecyclerView.Adapter<AssignmentListAdapter.ViewHolder>{
    private List<AssignmentListData> listdata;

    // RecyclerView recyclerView;
    public AssignmentListAdapter(List<AssignmentListData> listdata) {
        this.listdata = listdata;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.assignment_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.subject_id.setText(listdata.get(position).getSubject_id());
        holder.assignment_details.setText(listdata.get(position).getAssignment_details());
        holder.due_date.setText(listdata.get(position).getDue_date());
    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView subject_id;
        public TextView assignment_details;
        public TextView due_date;
        public ViewHolder(View itemView) {
            super(itemView);
            this.subject_id = (TextView) itemView.findViewById(R.id.subject_name);
            this.assignment_details = (TextView) itemView.findViewById(R.id.assignment_description);
            this.due_date = (TextView) itemView.findViewById(R.id.assignment_due_date);
        }
    }
}
