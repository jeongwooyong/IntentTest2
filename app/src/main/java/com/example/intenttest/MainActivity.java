package com.example.intenttest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final int GET_RESULT = 1;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      tvResult = findViewById(R.id.tvResult);
      Button btnopen = findViewById(R.id.btnopen);
      EditText edtText = findViewById(R.id.edtText);

      btnopen.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(MainActivity.this, SubActivity.class);
              intent.putExtra("imageName",edtText.getText().toString());
              startActivityForResult(intent,GET_RESULT);
          }
      });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == GET_RESULT) {
            if (resultCode == RESULT_OK) {
                tvResult.setText(""+data.getIntExtra("RESULT",0));
            }
        }
    }
}