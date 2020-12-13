package com.ai.proiect_cebuc_gabriel_catalin_1079;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PropertiesPropActivity extends AppCompatActivity {
    private Button adugareApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_properties_prop);
        adugareApp = findViewById(R.id.adugare_app);
        adugareApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PropertiesPropActivity.this, FormAddFlatPropActivity.class);
                startActivity(intent);
            }
        });
    }
}