package com.ai.proiect_cebuc_gabriel_catalin_1079;

import android.app.Application;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class Module extends Application {
    public ArrayList<String> garrList =  new ArrayList<>();
    public ArrayAdapter<String> garrAdapter;
    public String id;
    public String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
