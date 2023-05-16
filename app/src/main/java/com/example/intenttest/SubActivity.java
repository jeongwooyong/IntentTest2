package com.example.intenttest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subactivity);
        EditText edtImageName = findViewById(R.id.edtImageName);
        Intent intent = getIntent();
        edtImageName.setText(intent.getStringExtra("imageName"));

        Intent intentsub = new Intent();
        Button btnModified = findViewById(R.id.btnModified);
        btnModified.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentsub.putExtra("RESULT",edtImageName.getText().toString());
                setResult(RESULT_OK,intentsub);
                finish();
            }
        });
        Button btnclose = findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}
