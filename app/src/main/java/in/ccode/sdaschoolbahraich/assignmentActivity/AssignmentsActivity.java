package in.ccode.sdaschoolbahraich.assignmentActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import in.ccode.sdaschoolbahraich.R;

public class AssignmentsActivity extends AppCompatActivity {

    TextView month;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM");
    Date date = new Date();

    // Access a Cloud Firestore instance from your Activity
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private List<AssignmentListData> myListData;
    private AssignmentListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignments);

        month = (TextView) findViewById(R.id.assignment_month);
        month.setText(simpleDateFormat.format(date));

        myListData = new ArrayList<>();
        listAdapter = new AssignmentListAdapter(myListData);

        db.collection("assignment").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null) {

                }
                for (DocumentChange doc : queryDocumentSnapshots.getDocumentChanges()) {
                    if (doc.getType() == DocumentChange.Type.ADDED) {
                        AssignmentListData listData = doc.getDocument().toObject(AssignmentListData.class);
                        myListData.add(listData);
                        listAdapter.notifyDataSetChanged();
                    }
                }
            }
        });

        /*db.collection("assignment")
                .whereEqualTo("subject_id", "12PHY")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("Assignment Activity", document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.d("Assignment Activity", "Error getting documents: ", task.getException());
                        }
                    }
                });*/

        /*AssignmentListData[] myListData = new AssignmentListData[]{
                new AssignmentListData("Computer", "Write a java program to calculate the sum of n numbers ", "10 April 2020"),
                new AssignmentListData("Biology", "Write a java program to calculate the sum of n numbers ", "10 April 2020"),
                new AssignmentListData("Computer", "Write a java program to calculate the sum of n numbers ", "10 April 2020"),
                new AssignmentListData("Biology", "Write a java program to calculate the sum of n numbers ", "10 April 2020"),
        };*/

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.assignment_recycler_view);
        AssignmentListAdapter adapter = new AssignmentListAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
