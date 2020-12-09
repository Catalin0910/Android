package com.ai.proiect_cebuc_gabriel_catalin_1079;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.room.Room;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ai.proiect_cebuc_gabriel_catalin_1079.data.UserDatabase;
import com.ai.proiect_cebuc_gabriel_catalin_1079.data.UserPropDatabase;
import com.ai.proiect_cebuc_gabriel_catalin_1079.model.User;
import com.ai.proiect_cebuc_gabriel_catalin_1079.model.UserProp;
import com.google.android.material.navigation.NavigationView;

public class ProfilePropActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private UserProp user;
    private Button delete;
    private UserPropDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_prop);

        drawerLayout =  findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        navigationView.bringToFront();
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toogle =  new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();
        db = Room.databaseBuilder(this, UserPropDatabase.class, "Users")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        delete = findViewById(R.id.deleteaccount);


        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_profile);
        TextView prenume = findViewById(R.id.prenume);
        TextView email = findViewById(R.id.adresaemail);
        TextView parola = findViewById(R.id.parola);
        user = (UserProp) getIntent().getSerializableExtra("Users");
        if(user != null) {
            prenume.setText(user.getUserName());
            email.setText(user.getEmail());
            parola.setText(user.getPassword());
        }

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        AsyncTask.execute(new Runnable() {
                            @Override
                            public void run() {
                                db.getUserPropDao().delete(user);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        AlertDialog.Builder builder = new AlertDialog.Builder(ProfilePropActivity.this);
                                        builder.setTitle("Important!!");
                                        builder.setMessage("Your account has been deleted");
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

                            }
                        });
                    }
                });
            }
        });


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
                Intent intent = new Intent(ProfilePropActivity.this, HomePagePropActivity.class);
                intent.putExtra("User", user);
                startActivity(intent);
                break;
            case R.id.nav_rent:
                Intent intent1 =  new Intent(ProfilePropActivity.this, RentActivity.class);
                intent1.putExtra("UserRent", user);
                startActivity(intent1);
                break;
            case R.id.nav_profile:
                break;
            case R.id.nav_logut:
                SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("rember", "false");
                editor.apply();
                Intent intent2 =  new Intent(ProfilePropActivity.this, MainActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.nav_rate:
                Intent intent3 = new Intent(ProfilePropActivity.this, RatePropActivity.class);
                intent3.putExtra("UserRate", user);
                startActivity(intent3);
                break;
            case R.id.nav_graf:
                Intent intent4 = new Intent(ProfilePropActivity.this, GrafPropActivity.class);
                intent4.putExtra("UserGraf", user);
                startActivity(intent4);
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}