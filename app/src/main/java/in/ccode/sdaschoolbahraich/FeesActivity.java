package in.ccode.sdaschoolbahraich;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class FeesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fees);

        FeeListData[] myListData =new FeeListData[]{
                new FeeListData("April", "31-03-20", "3500", "B123"),
                new FeeListData("April", "31-03-20", "3500", "B123"),
                new FeeListData("April", "31-03-20", "3500", "B123"),
        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.fee_recycler_view);
        FeeListAdapter adapter = new FeeListAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
