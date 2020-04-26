package in.ccode.sdaschoolbahraich.loginActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import in.ccode.sdaschoolbahraich.mainActivity.MainActivity;
import in.ccode.sdaschoolbahraich.R;

public class LoginActivity extends AppCompatActivity {

    // Access a Cloud Firestore instance from your Activity
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    Button loginButton;
    EditText userID, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = (Button) findViewById(R.id.login_button);
        userID = (EditText) findViewById(R.id.user_id);
        password = (EditText) findViewById(R.id.password);
        //TODO change for login
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(userID.getText().toString().trim().isEmpty())) {
                    DocumentReference docRef = db.collection("student").document(userID.getText().toString().trim());
                    docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if (task.isSuccessful()) {
                                DocumentSnapshot document = task.getResult();
                                if (document.exists()) {
                                    if ((userID.getText().toString().trim().equals(document.getString("roll_no")))
                                            && (password.getText().toString().trim().equals(document.getString("password")))) {
                                        SharedPreferences preferences = getSharedPreferences(getResources().getString(R.string.preference_roll_no), MODE_PRIVATE);
                                        SharedPreferences.Editor editor = preferences.edit();
                                        editor.putString("profile_roll_no", document.getString("roll_no"));
                                        editor.apply();

                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        Toast.makeText(LoginActivity.this, "Check Credentials", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Log.d("Login Activity", "No such document");
                                }
                            } else {
                                Log.d("Login Activity", "get failed with ", task.getException());
                            }
                        }
                    });
                }
            }
        });
    }
}
