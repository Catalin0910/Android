package com.ai.proiect_cebuc_gabriel_catalin_1079;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ApartamenteAdapter extends BaseAdapter {

    private ArrayList<Apartemnte> apartemntes;
    private Context context;
    private LayoutInflater inflater;
    private int rImags[];

    public ApartamenteAdapter(Context context, ArrayList<Apartemnte> apartemntes, int rImags[] ) {
        this.context = context;
        this.apartemntes = apartemntes;
        this.rImags = rImags;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return apartemntes.size();
    }

    @Override
    public Object getItem(int position) {
        return apartemntes.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    public int[] getrImags() {
        return rImags;
    }

    public void setrImags(int[] rImags) {
        this.rImags = rImags;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View item = inflater.inflate(R.layout.row, parent, false);
        TextView tvTitlul = item.findViewById(R.id.tv_titlu);
        TextView tvDescriere = item.findViewById(R.id.tv_descriere);
        ImageView view = item.findViewById(R.id.imagineap);

        Apartemnte apartemnte = apartemntes.get(position);
        tvTitlul.setText(apartemnte.getTitlu());
        tvDescriere.setText(apartemnte.getDescriereScurta());
        view.setImageResource(rImags[position]);
        return  item;
    }

    public void addItems(Apartemnte list){
       apartemntes.add(list);
        notifyDataSetChanged();
    }

//    private Context context;
//    private String rTitle[];
//    private String rDescription[];
//
//
//    public ApartamenteAdapter(@NonNull Context context, String[] rTitle, String[] rDescription, int[] rImags) {
//        super(context, R.layout.row, R.id.tv_titlu, rTitle);
//        this.context = context;
//        this.rTitle = rTitle;
//        this.rDescription = rDescription;
//        this.rImags = rImags;
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View row = layoutInflater.inflate(R.layout.row, parent, false);
//        ImageView view = row.findViewById(R.id.iimagine);
//        TextView myTitle = row.findViewById(R.id.tv_titlu);
//        TextView myDescriere = row.findViewById(R.id.tv_descriere);
//        view.setImageResource(rImags[position]);
//        myTitle.setText(rTitle[position]);
//        myDescriere.setText(rDescription[position]);
//        return row;
//    }
}
