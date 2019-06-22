package com.example.expandablelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;

    List<String> langs;
    Map<String,List<String>> topics;
    ExpandableListAdapter expandableListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = findViewById(R.id.expandableListView);
        fillData();
        expandableListAdapter = new MyExpandableListviewAdapter(this,langs,topics);
        expandableListView.setAdapter(expandableListAdapter);


        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                Toast.makeText(MainActivity.this,langs.get(i)+" --> "+topics.get(langs.get(i)).get(i1),Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }

    public void fillData(){
        langs = new ArrayList<>();
        topics = new HashMap<>();

        langs.add("JAVA");
        langs.add("C");

        List<String> java = new ArrayList<>();
        List<String> c = new ArrayList<>();

        java.add("Super");
        java.add("Encapsulation");
        java.add("Methods");

        c.add("Procedure");
        c.add("Pointers");
        c.add("Array");

        topics.put(langs.get(0),java);
        topics.put(langs.get(1),c);
    }
}
