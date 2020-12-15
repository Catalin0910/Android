package com.ai.proiect_cebuc_gabriel_catalin_1079;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ai.proiect_cebuc_gabriel_catalin_1079.data.UserPropDatabase;
import com.ai.proiect_cebuc_gabriel_catalin_1079.model.UserProp;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class GrafPropActivity extends AppCompatActivity {
    private BarChart chart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_graf_prop);
        chart = findViewById(R.id.barChart);
        ArrayList<BarEntry> valoareEuro = new ArrayList<>();
        valoareEuro.add(new BarEntry(1, (float) 4.78));
        valoareEuro.add(new BarEntry(2, (float) 4.60));
        valoareEuro.add(new BarEntry(3, (float) 4.72));
        valoareEuro.add(new BarEntry(4, (float) 4.82));
        valoareEuro.add(new BarEntry(5, (float) 4.83));
        valoareEuro.add(new BarEntry(6, (float) 4.84));
        valoareEuro.add(new BarEntry(7, (float) 4.8319));
        valoareEuro.add(new BarEntry(8, (float) 4.8347));
        valoareEuro.add(new BarEntry(9, (float) 4.8492));
        valoareEuro.add(new BarEntry(10, (float) 4.872));
        valoareEuro.add(new BarEntry(11, (float) 4.8735));
        valoareEuro.add(new BarEntry(12, (float) 4.8693));

        BarDataSet barDataSet = new BarDataSet(valoareEuro, "Valoare Euro");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(20f);

        BarData barData = new BarData(barDataSet);

        chart.setFitBars(true);
        chart.setData(barData);
        chart.getDescription().setText("Barchartu-ul valorii euro in lei pe parcursul anului 2020");
        chart.animateY(1500);


    }


}