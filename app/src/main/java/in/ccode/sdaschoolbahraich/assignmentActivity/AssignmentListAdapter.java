package in.ccode.sdaschoolbahraich.assignmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import in.ccode.sdaschoolbahraich.R;


public class AssignmentListAdapter extends RecyclerView.Adapter<AssignmentListAdapter.ViewHolder>{
    private AssignmentListData[] listdata;

    // RecyclerView recyclerView;
    public AssignmentListAdapter(AssignmentListData[] listdata) {
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
        holder.subjectName.setText(listdata[position].getSubjectName());
        holder.subjectDescription.setText(listdata[position].getDescription());
        holder.subjectDueDate.setText(listdata[position].getSubjectDueDate());
    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView subjectName;
        public TextView subjectDescription;
        public TextView subjectDueDate;
        public ViewHolder(View itemView) {
            super(itemView);
            this.subjectName = (TextView) itemView.findViewById(R.id.subject_name);
            this.subjectDescription = (TextView) itemView.findViewById(R.id.assignment_description);
            this.subjectDueDate = (TextView) itemView.findViewById(R.id.assignment_due_date);
        }
    }
}
