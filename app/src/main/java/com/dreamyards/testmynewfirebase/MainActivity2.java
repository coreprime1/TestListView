package com.dreamyards.testmynewfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private ListView mListView;
    Tache[] values = new Tache[] { new Tache("Android", "iPhone"), new Tache("WindowsMobile",
            "Blackberry"), new Tache("WebOS", "Ubuntu"), new Tache("Windows7", "Max OS X"),
            new Tache("Linux", "OS/2"), new Tache("Ubuntu", "Windows7"),
            new Tache("Max OS X", "Linux"),new Tache("OS/2", "Ubuntu"),
            new Tache("Windows7", "Max OS X"),
            new Tache("Linux", "OS/2"),new Tache("Android", "iPhone")};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mListView = findViewById(R.id.listview);

        final ArrayList<Tache> list = new ArrayList<Tache>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }

        final StableArrayAdapter adapter = new StableArrayAdapter(this,
                R.layout.mise_en_forme_contenu_listview, list);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //je fais quelque chose ici selon ce qui est choisi dans la liste.
                TextView name = view.findViewById(R.id.tache_titre);
                TextView description = view.findViewById(R.id.tache_description);
                Toast.makeText(getApplicationContext(),
                                "nom est : " + name.getText()+" et la description est "
                                + description.getText(), Toast.LENGTH_LONG).show();
            }
        });
    }
}