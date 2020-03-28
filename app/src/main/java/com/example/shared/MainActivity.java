package com.example.shared;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edText;
    private Button btnSave,btnLoad;
    private SharedPreferences sPref;
    final String SAVED_TEXT="Saved_text";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edText=findViewById(R.id.etText);
        btnSave=findViewById(R.id.save);
        btnSave.setOnClickListener(this);
        btnLoad=findViewById(R.id.load);
        btnLoad.setOnClickListener(this);
        ListView listView=findViewById(R.id.list);
        ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
        HashMap<String,String> map1=new HashMap<>();
        map1.put("Name","Мурзик");
        map1.put("tel","5766777");
        arrayList.add(map1);
        HashMap<String,String> map2=new HashMap<>();
        map2.put("Name","Васька");
        map2.put("tel","6546464");
        arrayList.add(map2);
        SimpleAdapter adapter=new SimpleAdapter(this,arrayList,android.R.layout.simple_list_item_2,new String[]{"Name","Tel"},
                new int[]{android.R.id.text1,android.R.id.text1});
        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.save:
                sPref=getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor ed=sPref.edit();
                ed.putString(SAVED_TEXT,edText.getText().toString());
                ed.commit();
                Toast.makeText(this,"Text saved",Toast.LENGTH_SHORT).show();
                break;
            case R.id. load:
                sPref=getPreferences(MODE_PRIVATE);
                String savedText=sPref.getString(SAVED_TEXT,"");
                edText.setText(savedText);

        }
    }
}
