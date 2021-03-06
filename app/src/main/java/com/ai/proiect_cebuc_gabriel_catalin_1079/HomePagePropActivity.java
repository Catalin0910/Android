package com.ai.proiect_cebuc_gabriel_catalin_1079;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ai.proiect_cebuc_gabriel_catalin_1079.model.User;
import com.ai.proiect_cebuc_gabriel_catalin_1079.model.UserProp;
import com.google.android.material.navigation.NavigationView;

public class HomePagePropActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private TextView nameUser;
    private UserProp user;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_prop);

        drawerLayout =  findViewById(R.id.drawer_layout);
        navigationView =  findViewById(R.id.navigation_view);
        toolbar =  findViewById(R.id.toolbar);
        navigationView.bringToFront();
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toogle =  new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        user = (UserProp) getIntent().getSerializableExtra("User");
        nameUser = findViewById(R.id.name);
        if(user != null) {
            nameUser.setText("Hello " + user.getUserName());
        }

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
                break;
            case R.id.nav_rent:
                Intent intent =  new Intent(HomePagePropActivity.this, PropertiesPropActivity.class);
                intent.putExtra("UserRent", user);
                startActivity(intent);
                break;
            case R.id.nav_profile:
                Intent intent1 =  new Intent(HomePagePropActivity.this, ProfilePropActivity.class);
                intent1.putExtra("Users", user);
                startActivity(intent1);
                break;
            case R.id.nav_logut:
                SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("rember", "false");
                editor.apply();
                Intent intent2 =  new Intent(HomePagePropActivity.this, MainActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.nav_rate:
                Intent intent3 = new Intent(HomePagePropActivity.this, RatePropActivity.class);
                intent3.putExtra("UserRate", user);
                startActivity(intent3);
                break;
            case R.id.nav_graf:
                Intent intent4 = new Intent(HomePagePropActivity.this, GrafPropActivity.class);
                intent4.putExtra("UserGraf", user);
                startActivity(intent4);
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}