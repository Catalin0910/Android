package com.ai.proiect_cebuc_gabriel_catalin_1079;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.ai.proiect_cebuc_gabriel_catalin_1079.model.UserProp;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class PropertiesPropActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Button adugareApp;
    private DatabaseReference databaseReference;
    private ListView listView;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    private UserProp user;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_properties_prop);

        drawerLayout =  findViewById(R.id.drawer_layout);
        navigationView =  findViewById(R.id.navigation_view);
        toolbar =  findViewById(R.id.toolbar);
        navigationView.bringToFront();
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toogle =  new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_rent);

        user = (UserProp) getIntent().getSerializableExtra("UserRent");
        if(user!=null){
            user.getUserName();
            user.getEmail();
            user.getPassword();

        }

        //adugare date in listview din Firebase
        databaseReference= FirebaseDatabase.getInstance().getReference("apartamente");
        listView = findViewById(R.id.listview_app);
        arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
       databaseReference.addChildEventListener(new ChildEventListener() {
           @Override
           public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
               String value = snapshot.getValue(ApartamenteClass.class).toString();
               arrayList.add(value);
               arrayAdapter.notifyDataSetChanged();

           }

           @Override
           public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

           }

           @Override
           public void onChildRemoved(@NonNull DataSnapshot snapshot) {

           }

           @Override
           public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
       });

        adugareApp = findViewById(R.id.adugare_app);
        adugareApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PropertiesPropActivity.this, FormAddFlatPropActivity.class);
                intent.putExtra("UserRent2", user);
                startActivity(intent);
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
                Intent intent =  new Intent(PropertiesPropActivity.this, HomePagePropActivity.class);
                intent.putExtra("User", user);
                startActivity(intent);
            case R.id.nav_rent:
                break;
            case R.id.nav_profile:
                Intent intent1 =  new Intent(PropertiesPropActivity.this, ProfilePropActivity.class);
                intent1.putExtra("Users", user);
                startActivity(intent1);
                break;
            case R.id.nav_logut:
                SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("rember", "false");
                editor.apply();
                Intent intent2 =  new Intent(PropertiesPropActivity.this, MainActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.nav_rate:
                Intent intent3 = new Intent(PropertiesPropActivity.this, RatePropActivity.class);
                intent3.putExtra("UserRate", user);
                startActivity(intent3);
                break;
            case R.id.nav_graf:
                Intent intent4 = new Intent(PropertiesPropActivity.this, GrafPropActivity.class);
                intent4.putExtra("UserGraf", user);
                startActivity(intent4);
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}