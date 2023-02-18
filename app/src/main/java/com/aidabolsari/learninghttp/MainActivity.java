package com.aidabolsari.learninghttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.json.JSONException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSend = (Button) findViewById(R.id.button);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThingSpeakClientManager manager = new ThingSpeakClientManager();
                try {
                    manager.getField2();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}