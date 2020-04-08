package in.ccode.sdaschoolbahraich;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CardView attendanceMenu;
    CardView assignmentMenu;
    CardView calendarMenu;
    CardView marksMenu;
    CardView circularsMenu;
    CardView feesMenu;

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
}
