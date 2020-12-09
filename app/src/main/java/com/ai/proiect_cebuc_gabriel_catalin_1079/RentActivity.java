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
import android.os.Parcelable;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ai.proiect_cebuc_gabriel_catalin_1079.model.User;
import com.google.android.material.navigation.NavigationView;

import java.io.Serializable;
import java.util.ArrayList;

public class RentActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ListView listView;
    private ApartamenteAdapter apartamenteAdapter;
    private ArrayList<Apartemnte> apartemntesListItems = new ArrayList<>();
    int images[] = {R.drawable.ap1, R.drawable.ap2, R.drawable.ap3,
            R.drawable.ap4, R.drawable.ap5,
            R.drawable.ap6, R.drawable.ap7, R.drawable.ap8,
            R.drawable.ap9, R.drawable.ap10};

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent);

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

        user = (User)getIntent().getSerializableExtra("UserRent");;
        if(user != null) {
        user.getUserName();
        user.getUserFamilyName();
        user.getUserName();
        user.getPassword();
        }

        listView = findViewById(R.id.lv_aprtamente);
        setUpAdapter();

        DownloadAprtamente.getInstance().getApartmentData(new IApartement() {
            @Override
            public void onSucces(final ArrayList<Apartemnte> apartemntes) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for(Apartemnte ap: apartemntes){
                            apartamenteAdapter.addItems(ap);

                        }
                    }
                });
            }

            @Override
            public void onFailure(int errorCode, Throwable error) {
                Log.v("rent1", error + error.getLocalizedMessage());
            }
        });


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(RentActivity.this, RentPart2Activity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("image", images[position]);
                    intent.putExtras(bundle);
                    intent.putExtra("titlu", ((Apartemnte) apartamenteAdapter.getItem(position)).getTitlu());
                    intent.putExtra("descriere2", "Descriere: " + ((Apartemnte) apartamenteAdapter.getItem(position)).getDescriereLunga());
                    intent.putExtra("pret", "Pret: " + ((Apartemnte) apartamenteAdapter.getItem(position)).getPret());
                    intent.putExtra("contact", "Date contact: " +
                            ((Apartemnte) apartamenteAdapter.getItem(position)).getDateContact());
                    intent.putExtra("position", ""+position);
                    startActivity(intent);
                    Log.v("mama", intent.toString());
                return true;

            }
        });
    }

    private void setUpAdapter(){
        apartamenteAdapter = new ApartamenteAdapter(this, apartemntesListItems, images);
        listView.setAdapter(apartamenteAdapter);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent intent =  new Intent(RentActivity.this, HomePageActivity.class);
                intent.putExtra("User", user);
                startActivity(intent);
                break;
            case R.id.nav_rent:
                break;
            case R.id.nav_profile:
                Intent intent1 =  new Intent(RentActivity.this,ProfileActivity.class);
                intent1.putExtra("Users", user);
                startActivity(intent1);
                break;
            case R.id.nav_logut:
                SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("rember", "false");
                editor.apply();
                Intent intent2 =  new Intent(RentActivity.this, MainActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.nav_rate:
                Intent intent3 = new Intent(RentActivity.this, RatingActivity.class);
                intent3.putExtra("UserRate", user);
                startActivity(intent3);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
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
}




    //ApartamenteAdapter adapter = new ApartamenteAdapter(this, mTitle, mDescription, images);
    //listView.setAdapter(adapter);

//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                if(position == 0){
//                    Toast.makeText(RentActivity.this, "Facebook descriere", Toast.LENGTH_SHORT).show();
//                }
//                if(position == 0){
//                    Toast.makeText(RentActivity.this, "mama descriere", Toast.LENGTH_SHORT).show();
//                }
//                if(position == 0){
//                    Toast.makeText(RentActivity.this, "tata descriere", Toast.LENGTH_SHORT).show();
//                }
//                if(position == 0){
//                    Toast.makeText(RentActivity.this, "soramea descriere", Toast.LENGTH_SHORT).show();
//                }
//                if(position == 0){
//                    Toast.makeText(RentActivity.this, "fluffy descriere", Toast.LENGTH_SHORT).show();
//                }
//                return true;
//            }
//        });
