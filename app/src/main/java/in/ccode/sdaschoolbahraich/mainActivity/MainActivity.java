package in.ccode.sdaschoolbahraich.mainActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.StorageReference;

import in.ccode.sdaschoolbahraich.assignmentActivity.AssignmentsActivity;
import in.ccode.sdaschoolbahraich.attendanceActivity.AttendanceActivity;
import in.ccode.sdaschoolbahraich.calendarActivity.CalendarActivity;
import in.ccode.sdaschoolbahraich.circularActivity.CircularsActivity;
import in.ccode.sdaschoolbahraich.feesActivity.FeesActivity;
import in.ccode.sdaschoolbahraich.marksActivity.MarksActivity;
import in.ccode.sdaschoolbahraich.R;

public class MainActivity extends AppCompatActivity {

    CardView attendanceMenu;
    CardView assignmentMenu;
    CardView calendarMenu;
    CardView marksMenu;
    CardView circularsMenu;
    CardView feesMenu;
    TextView name,class_name,roll_no;
    ImageView profile_image;

    // Access a Cloud Firestore instance from your Activity
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        attendanceMenu = (CardView) findViewById(R.id.attendance_menu);
        assignmentMenu = (CardView) findViewById(R.id.assignment_menu);
        calendarMenu = (CardView) findViewById(R.id.calendar_menu);
        marksMenu = (CardView) findViewById(R.id.marks_menu);
        circularsMenu = (CardView) findViewById(R.id.circulars_menu);
        feesMenu = (CardView) findViewById(R.id.fees_menu);
        name = (TextView) findViewById(R.id.name);
        class_name = (TextView) findViewById(R.id.class_section);
        roll_no = (TextView) findViewById(R.id.roll_no);
        profile_image = (ImageView) findViewById(R.id.profile_image);

        SharedPreferences preferences = getSharedPreferences(getResources().getString(R.string.preference_roll_no),MODE_PRIVATE);
        String sharedRollNo = preferences.getString("profile_roll_no", "");
        updateProfile(sharedRollNo);

        attendanceMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AttendanceActivity.class);
                startActivity(intent);
            }
        });

        assignmentMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AssignmentsActivity.class);
                startActivity(intent);
            }
        });

        calendarMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalendarActivity.class);
                startActivity(intent);
            }
        });

        marksMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MarksActivity.class);
                startActivity(intent);
            }
        });

        circularsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CircularsActivity.class);
                startActivity(intent);
            }
        });

        feesMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FeesActivity.class);
                startActivity(intent);
            }
        });
    }

    private void updateProfile(String shareRollNo) {
        DocumentReference docRef = db.collection("student").document(shareRollNo);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        name.setText(new StringBuilder().append(document.getString("first_name")).append(" ").append(document.getString("last_name")).toString());
                        roll_no.setText(document.getString("roll_no"));


                        db.collection("classroom")
                                .whereEqualTo("classroom_id", document.getString("classroom_id"))
                                .get()
                                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                        if (task.isSuccessful()) {
                                            for (QueryDocumentSnapshot document : task.getResult()) {
                                                //Log.d("Main Activity", document.getId() + " => " + document.getData());
                                                class_name.setText(new StringBuilder().append(document.getString("class")).append(" ").append(document.getString("section")).toString());
                                            }
                                        } else {
                                            Log.d("Main Activity", "Error getting documents: ", task.getException());
                                        }
                                    }
                                });


                        //class_name.setText();
                    } else {
                        Log.d("Main Activity", "No such document");
                    }
                } else {
                    Log.d("Main Activity", "get failed with ", task.getException());
                }
            }
        });
    }
}
