package com.ai.proiect_cebuc_gabriel_catalin_1079;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Insert;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.ai.proiect_cebuc_gabriel_catalin_1079.data.UserDao;
import com.ai.proiect_cebuc_gabriel_catalin_1079.data.UserDatabase;
import com.ai.proiect_cebuc_gabriel_catalin_1079.data.UserPropDao;
import com.ai.proiect_cebuc_gabriel_catalin_1079.data.UserPropDatabase;
import com.ai.proiect_cebuc_gabriel_catalin_1079.model.User;
import com.ai.proiect_cebuc_gabriel_catalin_1079.model.UserProp;

import es.dmoral.toasty.Toasty;

public class RegisterActivity extends AppCompatActivity {

    private EditText etFirstName;
    private EditText etLastName;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etRePassword;
    private RadioGroup radioGroup;
    private RadioButton rbOpt1;
    private RadioButton rbOpt2;
    private CheckBox cbConsent;
    private Switch swEmail;
    private Button btnSubmit;
    private UserDao userDao;
    private UserPropDao userPropDao;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initViews();
        setupListeners();


        userDao = Room.databaseBuilder(this, UserDatabase.class, "Users").allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build().getUserDao();
        userPropDao =  Room.databaseBuilder(this, UserPropDatabase.class, "UsersProp").allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build().getUserPropDao();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = etFirstName.getText().toString();
                String userFamilyName = etLastName.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String tipchiras1 =  rbOpt1.getText().toString();
                String tipchiras2 =  rbOpt2.getText().toString();
                if(validateContent())
                {
                    if(!rbOpt1.isChecked()){

                        UserProp userProp = new UserProp(userName, email, password, tipchiras2);
                        userPropDao.insert(userProp);
                        Toast.makeText(RegisterActivity.this, "sunt in bd propietari", Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(moveToLogin);

                    }else {
                        User user = new User(userName, userFamilyName, email, password, tipchiras1);
                        userDao.insert(user);
                        Toast.makeText(RegisterActivity.this, "sunt in bd chiriasi", Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(moveToLogin);
                    }
                }
               else Toast.makeText(RegisterActivity.this, R.string.wrgRepass, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initViews() {
        etFirstName = findViewById(R.id.et_fstName);
        etLastName = findViewById(R.id.et_lastName);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_pass);
        etRePassword = findViewById(R.id.et_repass);
        radioGroup = findViewById(R.id.rg);
        rbOpt1 = findViewById(R.id.rb_op1);
        rbOpt2 = findViewById(R.id.rb_op2);
        cbConsent = findViewById(R.id.cb_consent);
        swEmail = findViewById(R.id.swi);
        btnSubmit = findViewById(R.id.btn_register);

    }

    private void setupListeners() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateContent()){
                    Clienti client = new Clienti();
                    client.setPrenume(etFirstName.getText().toString());
                    client.setNume(etLastName.getText().toString());
                    client.setEmail(etEmail.getText().toString());
                    client.setParola(etPassword.getText().toString());
                    client.setReparola(etRePassword.getText().toString());
                    int selectedRB = radioGroup.getCheckedRadioButtonId();
                    RadioButton rb = findViewById(selectedRB);
                    client.setTip(rb.getText().toString());
                    client.setConsent(cbConsent.isChecked());
                    client.setEmailAgrement(swEmail.isChecked());

                    Intent intent = new Intent();
                    intent.putExtra("client", client);
                    setResult(MainActivity.ADD_REQUEST_CODE, intent);

                    Toast.makeText(RegisterActivity.this, R.string.succes,
                            Toast.LENGTH_SHORT).show();



                } else {
                    Toast.makeText(RegisterActivity.this, R.string.invalid, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean validateContent() {
        if(etFirstName.getText().toString().isEmpty()){
            Toast.makeText(this, R.string.wrgFirstName, Toast.LENGTH_LONG ).show();
            return false;
        }
        if(etLastName.getText().toString().isEmpty()){
            Toast.makeText(this, R.string.wrgLastName, Toast.LENGTH_LONG ).show();
            return false;
        }

        String email = etEmail.getText().toString();

        if(email.isEmpty()){
            Toast.makeText(this, R.string.wrgEmail1, Toast.LENGTH_SHORT ).show();
            return false;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(this, R.string.wrgEmail, Toast.LENGTH_SHORT ).show();
            return false;
        }
        if(etPassword.getText().toString().isEmpty() ){
            Toast.makeText(this, R.string.wrhpass, Toast.LENGTH_SHORT ).show();
            return false;
        }
        if(etRePassword.getText().toString().isEmpty() ){
            Toast.makeText(this, R.string.wrhpass, Toast.LENGTH_SHORT ).show();
            return false;
        }
        if(!etPassword.getText().toString().equals(etRePassword.getText().toString())){
            Toast.makeText(this, R.string.wrgRepass, Toast.LENGTH_SHORT ).show();
            return false;
        }
        if(!cbConsent.isChecked()) {
            Toast.makeText(this, R.string.agree, Toast.LENGTH_SHORT ).show();
            return false;
        }
        if(radioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, R.string.user, Toast.LENGTH_SHORT ).show();
            return false;
        }
    return true;
    }


}