package com.ai.proiect_cebuc_gabriel_catalin_1079;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ai.proiect_cebuc_gabriel_catalin_1079.model.User;
import com.ai.proiect_cebuc_gabriel_catalin_1079.model.UserProp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FormAddFlatPropActivity extends AppCompatActivity {

    private EditText titlu, descriere, pret, contact;
    private Button addApartment, back;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    private UserProp user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_add_flat_prop);
        init();
        user = (UserProp) getIntent().getSerializableExtra("UserRent2");;
        if(user != null) {
            user.getUserName();
            user.getUserName();
            user.getPassword();
        }

        addApartment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode =  FirebaseDatabase.getInstance();
                reference = rootNode.getReference("apartamente");
                //iau toate valorile

                String title = titlu.getText().toString();
                String description = descriere.getText().toString();
                int price = Integer.parseInt(pret.getText().toString());
                String cont = contact.getText().toString();
                ApartamenteClass apartamenteAdugate = new ApartamenteClass(title, description, price, cont);

                reference.child(description).setValue(apartamenteAdugate);

                Toast.makeText(FormAddFlatPropActivity.this, R.string.texturaa, Toast.LENGTH_SHORT).show();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormAddFlatPropActivity.this, PropertiesPropActivity.class);
                intent.putExtra("UserRent", user);
                startActivity(intent);
            }
        });
    }

    private void init() {
        titlu = findViewById(R.id.titile);
        descriere = findViewById(R.id.description);
        pret = findViewById(R.id.pretfrate);
        contact = findViewById(R.id.contactme);
        addApartment = findViewById(R.id.astaadugap);
        back =  findViewById(R.id.back);
    }

}