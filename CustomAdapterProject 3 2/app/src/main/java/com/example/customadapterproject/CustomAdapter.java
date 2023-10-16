package com.example.customadapterproject;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<goat> {
    private final MainActivity mainActivity;
    Context main;
    List<goat> mylist;

    public CustomAdapter(MainActivity mainActivity, @NonNull Context context, int resource, @NonNull List<goat> objects) {
        super(context, resource, objects);
        this.mainActivity = mainActivity;
        main = context;
        mylist = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) main.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.adapter_custom, null);
        TextView textView = view.findViewById(R.id.id_adapter_text);
        ImageView image = view.findViewById(R.id.id_adapter_image);
        Button button1 = view.findViewById(R.id.id_adapter_button1);
        textView.setText(mylist.get(position).getName());
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mylist.remove(position);
                notifyDataSetChanged();
                mainActivity.tPort.setText("Sport: ");
                mainActivity.tPort2.setText("Age: ");
                if (mainActivity.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    mainActivity.tLand.setText("Championships: ");
                    mainActivity.tLand2.setText("Years Pro: ");
                    mainActivity.tLand3.setText("Achievement: ");
                    mainActivity.tLand4.setText("Thoughts: ");
                }
            }
        });
        image.setImageResource(mylist.get(position).getImage());
        mainActivity.listPort.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(mainActivity, "You Selected " + mylist.get(i).getName(), Toast.LENGTH_SHORT).show();
                mainActivity.tPort.setText("Sport: " + mylist.get(i).getSport());
                mainActivity.sport = mylist.get(i).getSport();
                mainActivity.tPort2.setText("Age: " + mylist.get(i).getAge());
                mainActivity.age = mylist.get(i).getAge();
                mainActivity.champs = mylist.get(i).getChamps();
                mainActivity.years = mylist.get(i).getYears();
                mainActivity.accolades = mylist.get(i).getAccolades();
                mainActivity.thoughts = mylist.get(i).getThoughts();
            }
        });
        if (mainActivity.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            mainActivity.listPort.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(mainActivity, "You Selected " + mylist.get(i).getName(), Toast.LENGTH_SHORT).show();
                    mainActivity.tPort.setText("Sport: " + mylist.get(i).getSport());
                    mainActivity.sport = mylist.get(i).getSport();
                    mainActivity.tPort2.setText("Age: " + mylist.get(i).getAge());
                    mainActivity.age = mylist.get(i).getAge();
                    mainActivity.tLand.setText("Championships: " + mylist.get(i).getChamps());
                    mainActivity.champs = mylist.get(i).getChamps();
                    mainActivity.tLand2.setText("Years Pro: " + mylist.get(i).getYears());
                    mainActivity.years = mylist.get(i).getYears();
                    mainActivity.tLand3.setText("Achievement: " + mylist.get(i).getAccolades());
                    mainActivity.accolades = mylist.get(i).getAccolades();
                    mainActivity.tLand4.setText("Thoughts: " + mylist.get(i).getThoughts());
                    mainActivity.thoughts = mylist.get(i).getThoughts();
                }
            });
        }
        return view;
    }
}
