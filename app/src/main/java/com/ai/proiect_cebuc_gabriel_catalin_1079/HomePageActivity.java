package com.ai.proiect_cebuc_gabriel_catalin_1079;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ai.proiect_cebuc_gabriel_catalin_1079.model.User;

public class HomePageActivity extends AppCompatActivity {

    private TextView nameUser;
    private User user;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        btnLogout =  findViewById(R.id.back);
        user = (User)getIntent().getSerializableExtra("User");
        nameUser = findViewById(R.id.name);
        if(user != null) {
            nameUser.setText("Welcome " + user.getUserName());
        }
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =  new Intent(HomePageActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}