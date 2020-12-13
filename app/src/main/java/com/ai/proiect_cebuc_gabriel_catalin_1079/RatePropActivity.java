package com.ai.proiect_cebuc_gabriel_catalin_1079;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.ai.proiect_cebuc_gabriel_catalin_1079.model.User;
import com.ai.proiect_cebuc_gabriel_catalin_1079.model.UserProp;
import com.google.android.material.navigation.NavigationView;

public class RatePropActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private TextView txtRating;
    private RatingBar rbrating;
    private Button rate;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private UserProp user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_prop);

        init();
        drawerLayout =  findViewById(R.id.drawer_layout);
        navigationView =  findViewById(R.id.navigation_view);
        toolbar =  findViewById(R.id.toolbar);
        navigationView.bringToFront();
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toogle =  new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_rate);


        rbrating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float ratingvalue, boolean fromUser) {
                String rating = "Rating is: " + ratingvalue;
                txtRating.setText(rating);
            }
        });

        rate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(RatePropActivity.this);
                builder.setTitle("Rating");
                builder.setMessage("Thank you for support us");
                builder.setCancelable(false);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        user = (UserProp) getIntent().getSerializableExtra("UserRate");
        if(user!=null){
            user.getUserName();
            user.getEmail();
            user.getPassword();

        }

    }

    private void init() {
        txtRating = findViewById(R.id.rate_us);
        rbrating = findViewById(R.id.ratingBar);
        rate = findViewById(R.id.btn_rate);
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent intent = new Intent(RatePropActivity.this, HomePagePropActivity.class);
                intent.putExtra("User", user);
                startActivity(intent);
                break;
            case R.id.nav_rent:
                Intent intent1 =  new Intent(RatePropActivity.this, PropertiesPropActivity.class);
                intent1.putExtra("UserRent", user);
                startActivity(intent1);
                break;
            case R.id.nav_profile:
                Intent intent3 = new Intent(RatePropActivity.this, ProfilePropActivity.class);
                intent3.putExtra("Users", user);
                startActivity(intent3);
                break;
            case R.id.nav_logut:
                SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("rember", "false");
                editor.apply();
                Intent intent2 =  new Intent(RatePropActivity.this, MainActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.nav_rate:
                break;
            case R.id.nav_graf:
                Intent intent4 = new Intent(RatePropActivity.this, GrafPropActivity.class);
                intent4.putExtra("UserGraf", user);
                startActivity(intent4);
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}