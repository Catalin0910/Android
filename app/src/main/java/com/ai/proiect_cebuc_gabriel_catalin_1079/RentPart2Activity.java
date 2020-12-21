package com.ai.proiect_cebuc_gabriel_catalin_1079;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.ai.proiect_cebuc_gabriel_catalin_1079.model.User;

import java.util.ArrayList;
import java.util.Arrays;

public class RentPart2Activity extends AppCompatActivity {

    private ImageView imageView;
    private GridView gridViewImage;
    private TextView tvTitlu;
    private  TextView tvDescriere;
    private  TextView tvPret;
    private  TextView tvContact;
    private Button btnBack;
    private User user;
    int position;
    ArrayList<Integer> mImagesIds = new ArrayList<>(Arrays.asList(R.drawable.ap1, R.drawable.ap2, R.drawable.ap3,
            R.drawable.ap4, R.drawable.ap5,
            R.drawable.ap6, R.drawable.ap7, R.drawable.ap8,
            R.drawable.ap9, R.drawable.ap10));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_part2);
        inital();

        user = (User)getIntent().getSerializableExtra("UserRent2");;
        if(user != null) {
            user.getUserName();
            user.getUserFamilyName();
            user.getUserName();
            user.getPassword();
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =  new Intent(RentPart2Activity.this, RentActivity.class);
                i.putExtra("UserRent", user);
                startActivity(i);
            }
        });

        gridViewImage.setAdapter(new ImageAdapter(mImagesIds, this));
        gridViewImage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int item_pos = mImagesIds.get(position);
                dialogArata(item_pos);
            }
        });


            Intent intent = getIntent();

            Bundle bundle = this.getIntent().getExtras();
             int pic = bundle.getInt("image");
            String aTitle = intent.getStringExtra("titlu");
            String descriere = intent.getStringExtra("descriere2");
            String pret = intent.getStringExtra("pret");
            String contact = intent.getStringExtra("contact");
            //imageView.setImageResource(pic);
            tvTitlu.setText(aTitle);
            tvDescriere.setText(descriere);
            tvPret.setText(pret);
            tvContact.setText(contact);

//        if( position == 0){
//            Intent intent = getIntent();
//
//            //Bundle bundle = this.getIntent().getExtras();
//           // int pic = bundle.getInt("image");
//            String aTitle = intent.getStringExtra("titlu");
//            String descriere = intent.getStringExtra("descriere2");
//            String pret = intent.getStringExtra("pret");
//            String contact = intent.getStringExtra("contact");
//            //imageView.setImageResource(pic);
//            tvTitlu.setText(aTitle);
//            tvDescriere.setText(descriere);
//            tvPret.setText(pret);
//            tvContact.setText(contact);
//        }

    }



    private void inital() {
        //imageView = findViewById(R.id.rent2_image);
        gridViewImage = findViewById(R.id.gv_poza);
        tvTitlu = findViewById(R.id.tv_titlu);
        tvDescriere = findViewById(R.id.tv_descriere2);
        btnBack = findViewById(R.id.btn_back_123);
        tvPret = findViewById(R.id.tv_pret);
        tvContact = findViewById(R.id.tv_contact);
    }

    public void dialogArata(int item){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_poza);
        ImageView imagine = dialog.findViewById(R.id.poza);
        Button btn = dialog.findViewById(R.id.inchide);
        imagine.setImageResource(item);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

}