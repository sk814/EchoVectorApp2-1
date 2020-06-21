package com.example.echovectorapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import static com.google.android.gms.tasks.Task.*;

public class Activity2 extends AppCompatActivity {

    private static final String TAG = "Activity2";
    private EditText name;
    private EditText email;
    private EditText password;
    private Button saveButton;


    //Keys
    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";

    //Connection to Firestore
    private FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        saveButton = findViewById(R.id.button2);
        email = findViewById(R.id.emailInput);
        name = findViewById(R.id.nameInput);
        password= findViewById(R.id.passwordInput);


        // Create a new user with a name, email, and password
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameField = name.getText().toString().trim();
                String emailField = email.getText().toString().trim();
                String passwordField = password.getText().toString().trim();
                Map<String, Object> user = new HashMap<>();

                user.put(KEY_NAME, nameField);
                user.put(KEY_EMAIL, emailField);
                user.put(KEY_PASSWORD, passwordField);


                db.collection("Users")
                        .add(user)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(Activity2.this, "Successfully registered!", Toast.LENGTH_LONG).show();
                                Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                            }
                            })


                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Activity2.this, "Error! Registration failed.", Toast.LENGTH_LONG).show();
                                Log.d(TAG, "onFailure: " + e.toString());
                            }

                        });


            }
        });

    }
}