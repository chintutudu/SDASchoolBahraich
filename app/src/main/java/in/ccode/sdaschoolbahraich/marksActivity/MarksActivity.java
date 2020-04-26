package in.ccode.sdaschoolbahraich.marksActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import in.ccode.sdaschoolbahraich.R;

public class MarksActivity extends AppCompatActivity {

    CardView subject1,subject2,subject3,subject4,subject5,subject6,subject7,subject8,subject9;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marks);

        intent = new Intent(MarksActivity.this, MarksOpenSubjectActivity.class);
        subject1 = findViewById(R.id.subject_1);
        subject2 = findViewById(R.id.subject_2);
        subject3 = findViewById(R.id.subject_3);
        subject4 = findViewById(R.id.subject_4);
        subject5 = findViewById(R.id.subject_5);
        subject6 = findViewById(R.id.subject_6);
        subject7 = findViewById(R.id.subject_7);
        subject8 = findViewById(R.id.subject_8);
        subject9 = findViewById(R.id.subject_9);
        subject1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
        subject2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
        subject3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
        subject4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
        subject5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
        subject6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
        subject7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
        subject8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
        subject9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}
