package com.ai.proiect_cebuc_gabriel_catalin_1079;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ai.proiect_cebuc_gabriel_catalin_1079.data.UserDao;
import com.ai.proiect_cebuc_gabriel_catalin_1079.data.UserDatabase;
import com.ai.proiect_cebuc_gabriel_catalin_1079.data.UserPropDao;
import com.ai.proiect_cebuc_gabriel_catalin_1079.data.UserPropDatabase;
import com.ai.proiect_cebuc_gabriel_catalin_1079.model.User;
import com.ai.proiect_cebuc_gabriel_catalin_1079.model.UserProp;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private Button btnSign;
    private EditText email;
    private EditText password;
    UserDao db;
    UserDatabase database;
    UserPropDao dbProp;
    UserPropDatabase databaseProp;


    public static int ADD_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btn = findViewById(R.id.btn_register);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, R.string.message, Toast.LENGTH_SHORT).show();
                Toasty.success(MainActivity.this, "Going", Toast.LENGTH_SHORT).show();
                Intent intent =  new Intent(MainActivity.this, RegisterActivity.class);
                startActivityForResult(intent, ADD_REQUEST_CODE);
            }
        });
        btnSign  = findViewById(R.id.btn_singin);

        database = Room.databaseBuilder(this, UserDatabase.class, "Users")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        databaseProp = Room.databaseBuilder(this, UserPropDatabase.class, "UsersProp")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        db = database.getUserDao();
        dbProp = databaseProp.getUserPropDao();
        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailUser =  email.getText().toString();
                String pass = password.getText().toString();
                String emailUser1 =  email.getText().toString();
                String pass1 = password.getText().toString();

                User user = db.getUser(emailUser, pass );
                UserProp userProp =  dbProp.getUserProp(emailUser1, pass1);

                if(user != null) {
                    Intent i = new Intent(MainActivity.this, HomePageActivity.class);
                    i.putExtra("User", user);
                    startActivity(i);
                    finish();
                }
                else if(userProp != null) {
                    Intent intent = new Intent(MainActivity.this, HomePagePropActivity.class);
                    intent.putExtra("User", userProp);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(MainActivity.this, R.string.propNot, Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
       if(requestCode == ADD_REQUEST_CODE) {
           if(data != null) {
               Clienti client = data.getParcelableExtra("client");
               Log.v("test", client.toString());
           }
       }
        super.onActivityResult(requestCode, resultCode, data);
    }


}