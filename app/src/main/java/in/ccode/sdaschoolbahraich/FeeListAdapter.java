package in.ccode.sdaschoolbahraich;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FeeListAdapter extends RecyclerView.Adapter<FeeListAdapter.ViewHolder> {
    private FeeListData[] listData;

    public FeeListAdapter(FeeListData[] listData) {
        this.listData = listData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.fee_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.feeMonthOf.setText(listData[position].getFeeMonthOf());
        holder.feeDatePaid.setText(listData[position].getFeeDatePaid());
        holder.feeAmountPaid.setText(listData[position].getFeeAmountPaid());
        holder.feeBillNo.setText(listData[position].getFeeBillNo());
    }

    @Override
    public int getItemCount() {
        return listData.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView feeMonthOf;
        public TextView feeDatePaid;
        public TextView feeAmountPaid;
        public TextView feeBillNo;

        public ViewHolder(View itemView) {
            super(itemView);
            this.feeMonthOf = (TextView) itemView.findViewById(R.id.fee_month);
            this.feeDatePaid = (TextView) itemView.findViewById(R.id.fee_date_paid);
            this.feeAmountPaid = (TextView) itemView.findViewById(R.id.fee_amount_paid);
            this.feeBillNo = (TextView) itemView.findViewById(R.id.fee_bill_no);
        }
    }
}
