package com.ai.proiect_cebuc_gabriel_catalin_1079;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ai.proiect_cebuc_gabriel_catalin_1079.data.UserDatabase;
import com.ai.proiect_cebuc_gabriel_catalin_1079.model.User;
import com.google.android.material.navigation.NavigationView;

public class ProfileActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private User user;
    private Button delete;
    private UserDatabase db;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        drawerLayout =  findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        navigationView.bringToFront();
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toogle =  new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();
        db = Room.databaseBuilder(this, UserDatabase.class, "Users")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        delete = findViewById(R.id.deleteaccount);


        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_profile);
        TextView prenume = findViewById(R.id.prenume);
        TextView numeFamilie = findViewById(R.id.numefamilie);
        TextView email = findViewById(R.id.adresaemail);
        TextView parola = findViewById(R.id.parola);
        user = (User) getIntent().getSerializableExtra("Users");
        if(user != null) {
            prenume.setText(user.getUserName());
            numeFamilie.setText(user.getUserFamilyName());
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
                                db.getUserDao().deleteUser(user);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
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
                Intent intent = new Intent(ProfileActivity.this, HomePageActivity.class);
                intent.putExtra("User", user);
                startActivity(intent);
                break;
            case R.id.nav_rent:
                Intent intent1 =  new Intent(ProfileActivity.this, RentActivity.class);
                intent1.putExtra("UserRent", user);
                startActivity(intent1);
                break;
            case R.id.nav_profile:
                break;
            case R.id.nav_logut:
                Intent intent2 =  new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(intent2);
                break;
            case R.id.nav_rate:
                Intent intent3 = new Intent(ProfileActivity.this, RatingActivity.class);
                intent3.putExtra("UserRate", user);
                startActivity(intent3);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}