package com.ai.proiect_cebuc_gabriel_catalin_1079;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ai.proiect_cebuc_gabriel_catalin_1079.model.User;
import com.ai.proiect_cebuc_gabriel_catalin_1079.model.UserProp;

public class HomePagePropActivity extends AppCompatActivity {

    private TextView nameUser;
    private UserProp userProp;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_prop);
        btnLogout =  findViewById(R.id.back);
        userProp = (UserProp) getIntent().getSerializableExtra("User");
        nameUser = findViewById(R.id.name);
        if(userProp != null) {
            nameUser.setText("Welcome " + userProp.getUserName());
        }
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =  new Intent(HomePagePropActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}