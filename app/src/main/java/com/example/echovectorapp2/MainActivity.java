package com.example.echovectorapp2;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button button; // Button for Activity 2 which is registration
    private Button button2; //Button for Activity 3 which is products
    private Button button3; //Button for Activity 4
    private Button addProducts; //Button for adding products
    private Button listProducts; //Button for listing products
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2(); // registration page
            }
        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3(); // Product Page
            }
        });

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4(); //  Upload Page
            }
        });

        listProducts = (Button) findViewById(R.id.productList);
        listProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listProducts(); //  List of products Page
            }
        });

        addProducts = (Button) findViewById(R.id.product_upload_button);
        addProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3_2(); //  Upload Page with image
            }
        });
    }

    /** Opens second activity which is the registraion page*/
    public void openActivity2() {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }

    /** Opens third activity which is the product page*/
    public void openActivity3() {
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }

    /** Opens fourth activity which is the upload page*/
    public void openActivity4() {
        Intent intent = new Intent(this, Activity4.class);
        startActivity(intent);
    }
    //To add products
    public void openActivity3_2() {
        Intent intent = new Intent(this, Activity3_2.class);
        startActivity(intent);
    }

    public void listProducts()
    {
        Intent intent = new Intent(this, ProductListActivity.class);
        startActivity(intent);
    }
}