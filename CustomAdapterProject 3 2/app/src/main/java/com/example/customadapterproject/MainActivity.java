package com.example.customadapterproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listPort;
    TextView tPort;
    TextView tPort2;
    ListView listLand;
    TextView tLand;
    TextView tLand2;
    TextView tLand3;
    TextView tLand4;
    ArrayList<goat> entries;
    private final static String KEY = "asdfghjkl";
    private final static String KEY2 = "qwertyuiop";
    private final static String KEY3 = "zxcvbnm";
    private final static String KEY4 = "qwertyuiopasdfghjkl";
    private final static String KEY5 = "asdfghjklzxcvbnm";
    private final static String KEY6 = "zxcvbnmqwertyuiop";
    private final static String KEY7 = "mnbvcxzlkjhgfdsa";
    private final static String KEY8 = "qazxswedcvfrtgb";
    String sport;
    int age;
    int champs;
    int years;
    String accolades;
    String thoughts;
    int images;
    String name;
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY, sport);
        outState.putInt(KEY2, age);
        outState.putInt(KEY3, champs);
        outState.putInt(KEY4, years);
        outState.putString(KEY5, accolades);
        outState.putString(KEY6, thoughts);
        outState.putInt(KEY7, images);
        outState.putString(KEY8, name);
    }
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        sport = savedInstanceState.getString(KEY);
        age = savedInstanceState.getInt(KEY2);
        champs = savedInstanceState.getInt(KEY3);
        years = savedInstanceState.getInt(KEY4);
        accolades = savedInstanceState.getString(KEY5);
        thoughts = savedInstanceState.getString(KEY6);
        images = savedInstanceState.getInt(KEY7);
        name = savedInstanceState.getString(KEY8);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listPort = findViewById(R.id.id_listPort);
        tPort = findViewById(R.id.id_port_text1);
        tPort2 = findViewById(R.id.id_port_text2);
        listLand = findViewById(R.id.id_listPort);
        tLand = findViewById(R.id.id_land_text1);
        tLand2 = findViewById(R.id.id_land_text2);
        tLand3 = findViewById(R.id.id_land_text3);
        tLand4 = findViewById(R.id.id_land_text4);
        entries = new ArrayList<goat>();
        entries.add(new goat("Michael Jordan", "Basketball", 58, 6, 14, " 6 Finals MVPs", "Jordan and LeBron have been debated as to who should be considered the GOAT. In my opinion, Michael Jordan should be the GOAT because of his 6-0 record in the finals.",R.drawable.michaeljordangoat));
        entries.add(new goat("Tom Brady", "Football", 44, 7, 21, "3 League MVPs", "Tom Brady is the undisputed GOAT of the NFL. He has 7 rings, which is more than any other franchise. That alone makes the argument very easy.",R.drawable.brady));
        entries.add(new goat("Lionel Messi", "Soccer", 34, 10, 18, "7 Ballon d'Or", "Messi and Ronaldo have their own debate when it comes to the GOAT of soccer. I believe Messi has been playing well for longer and his trophy collection is greater than Ronaldo's.",R.drawable.messi));
        entries.add(new goat("Roger Federer", "Tennis", 40, 20, 23, "8 Wimbledon Titles", "Federer has been playing at a high level for many years and he has managed to compete with Djokovic and Nadal, who are the other people in the GOAT debate for tennis.",R.drawable.federer));
        entries.add(new goat("Babe Ruth", "Baseball", 53, 7, 22, "714 Home Runs", "Babe Ruth is the GOAT of baseball and a singular moment captures his raw talent: he told the crowd he was going to hit a home run to right field and on the next pitch, he did exactly that.",R.drawable.ruth));
        entries.add(new goat("Muhammad Ali", "Boxing", 74, 56, 21, "37 KOs", "Ali only lost 5 out of 61 matches and so he was consistently winning. GOATS are successful and Ali was clearly successful in his boxing career.",R.drawable.ali));
        entries.add(new goat("Simone Biles", "Gymnastics", 24, 25, 7, "4 Gold Medals", "Simone Biles was special from a young age and already has 4 gold medals at age 28. She is another example of success and is easily the GOAT of gymnastics",R.drawable.biles));
        CustomAdapter customAdapter = new CustomAdapter(this, this, R.layout.adapter_custom, entries);
        listPort.setAdapter(customAdapter);
        if(savedInstanceState != null) {
            if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                sport = savedInstanceState.getString(KEY);
                tPort.setText("Sport: " + sport);
                age = savedInstanceState.getInt(KEY2);
                tPort2.setText("Age: " + age);
            }
            if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                sport = savedInstanceState.getString(KEY);
                tPort.setText("Sport: " + sport);
                age = savedInstanceState.getInt(KEY2);
                tPort2.setText("Age: " + age);
                champs = savedInstanceState.getInt(KEY3);
                tLand.setText("Championships: " + champs);
                years = savedInstanceState.getInt(KEY4);
                tLand2.setText("Years Pro: " + years);
                accolades = savedInstanceState.getString(KEY5);
                tLand3.setText("Achievement: " + accolades);
                thoughts = savedInstanceState.getString(KEY6);
                tLand4.setText("Thoughts: " + thoughts);
            }
        }
    }
}