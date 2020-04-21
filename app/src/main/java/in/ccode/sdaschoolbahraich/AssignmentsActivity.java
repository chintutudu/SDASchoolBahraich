package in.ccode.sdaschoolbahraich;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class AssignmentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignments);

        AssignmentListData[] myListData = new AssignmentListData[]{
                new AssignmentListData("Computer", "Write a java program to calculate the sum of n numbers ", "10 April 2020"),
                new AssignmentListData("Biology", "Write a java program to calculate the sum of n numbers ", "10 April 2020"),
                new AssignmentListData("Computer", "Write a java program to calculate the sum of n numbers ", "10 April 2020"),
                new AssignmentListData("Biology", "Write a java program to calculate the sum of n numbers ", "10 April 2020"),
        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.assignment_recycler_view);
        AssignmentListAdapter adapter = new AssignmentListAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
