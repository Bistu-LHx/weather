package com.test.weather;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SearchActivity extends AppCompatActivity {
    private EditText etContent;
    private RecyclerView recyclerview;
    private CollAdapter mCollAdapter;
    private List<City> citys = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        etContent =  findViewById(R.id.etContent);
        recyclerview =  findViewById(R.id.recyclerview);
        findViewById(R.id.btnGO).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = etContent.getText().toString();
                Intent intent = new Intent(SearchActivity.this,MainActivity.class);
                intent.putExtra("code",code);
                startActivity(intent);
            }
        });
        findViewById(R.id.btnCity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this,ProvinceActivity.class);
                startActivityForResult(intent,100);
            }
        });
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        mCollAdapter = new CollAdapter(this, citys);
        recyclerview.setAdapter(mCollAdapter);
        recyclerview.setFocusable(false);
        mCollAdapter.setOnClickListener(new CollAdapter.OnClickListener() {
            @Override
            public void onClick(int position) {
                City item = citys.get(position);
                Intent intent = new Intent(SearchActivity.this,MainActivity.class);
                intent.putExtra("code",item.city_code);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100&&resultCode==RESULT_OK){
           String code =  data.getStringExtra("code");

           if (!TextUtils.isEmpty(code)){
               Intent intent = new Intent(SearchActivity.this,MainActivity.class);
               intent.putExtra("code",code);
               startActivity(intent);
           }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        citys.clear();
        SharedPreferences spColl = getSharedPreferences("coll", MODE_PRIVATE);
        Map<String, ?> all = spColl.getAll();
        Set<String> keySet = all.keySet();
        for (String key:
                keySet ) {
            String name = spColl.getString(key,"");
            if (!TextUtils.isEmpty(name)){
                citys.add(new City(key,name));
            }
        }
        mCollAdapter.notifyDataSetChanged();
    }
}
