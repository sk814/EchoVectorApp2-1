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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Activity4 extends AppCompatActivity {

    private static final String TAG = "Activity4";
    private EditText product;
    private EditText description;
    private Button uploadButton;

    //Keys
    public static final String KEY_PRODUCT = "product";
    public static final String KEY_DESCRIPTION = "description";

    //Connection to Firestore
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        //Getting by ids
        uploadButton = findViewById(R.id.uploadButton);
        product = findViewById(R.id.productNameUpload);
        description = findViewById(R.id.productDescriptionUpload);

        // Create a new user with a name, email, and password
        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String productField = product.getText().toString().trim();
                String descriptionField = description.getText().toString().trim();

                Map<String, Object> products = new HashMap<>();


                products.put(KEY_PRODUCT, productField);
                products.put(KEY_DESCRIPTION, descriptionField);


                if(!TextUtils.isEmpty(productField)) {
                    db.collection("Products_Posted")
                            .add(products)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Toast.makeText(Activity4.this, "Successfully Uploaded!", Toast.LENGTH_LONG).show();
                                    Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(Activity4.this, "Error! Upload failed.", Toast.LENGTH_LONG).show();
                                    Log.d(TAG, "onFailure: " + e.toString());
                                }

                            });
                }else{
                    Toast.makeText(Activity4.this, "Please enter the product name.", Toast.LENGTH_LONG).show();
                }

            }
        });


    }

    /** Requests access to users gallery to choose a photo*/

    
}
