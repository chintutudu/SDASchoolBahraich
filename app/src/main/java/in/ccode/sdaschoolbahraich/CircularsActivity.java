package in.ccode.sdaschoolbahraich;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class CircularsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulars);

        CircularListData[] myListData = new CircularListData[]{
                new CircularListData("English Essay Writing Competation", "There will be an essay writing competition on 05-04-2020"),
                new CircularListData("English Essay Writing Competation", "There will be an essay writing competition on 05-04-2020"),
                new CircularListData("English Essay Writing Competation", "There will be an essay writing competition on 05-04-2020"),
        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.circular_recycler_view);
        CircularListAdapter adapter = new CircularListAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
