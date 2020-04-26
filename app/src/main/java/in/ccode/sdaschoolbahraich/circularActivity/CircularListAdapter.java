package in.ccode.sdaschoolbahraich.circularActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import in.ccode.sdaschoolbahraich.R;

public class CircularListAdapter extends RecyclerView.Adapter<CircularListAdapter.ViewHolder> {
    private CircularListData[] listdata;

    // RecyclerView recyclerView;
    public CircularListAdapter(CircularListData[] listdata) {
        this.listdata = listdata;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.curcular_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.circularHeading.setText(listdata[position].getCircularHeading());
        holder.circularDescription.setText(listdata[position].getCircularDescription());
    }

    @Override
    public int getItemCount() {
        return listdata.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView circularHeading;
        public TextView circularDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            this.circularHeading = (TextView) itemView.findViewById(R.id.circular_heading);
            this.circularDescription = (TextView) itemView.findViewById(R.id.circular_description);
        }
    }
}
