package com.test.weather;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProvinceActivity extends AppCompatActivity {
    private RecyclerView recyclerview;
    private CollAdapter mCollAdapter;
    private List<City> citys = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_province);
        recyclerview =  findViewById(R.id.recyclerview);

        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        mCollAdapter = new CollAdapter(this, citys);
        recyclerview.setAdapter(mCollAdapter);
        recyclerview.setFocusable(false);
        mCollAdapter.setOnClickListener(new CollAdapter.OnClickListener() {
            @Override
            public void onClick(int position) {
                City item = citys.get(position);
                String code = item.city_code;
                if (TextUtils.isEmpty(code)){
                    Intent intent = new Intent(ProvinceActivity.this,CityActivity.class);
                    intent.putExtra("id",item.id);
                    startActivityForResult(intent,100);
                }else{
                    Intent intent = new Intent();
                    intent.putExtra("code",code);
                    setResult(RESULT_OK,intent);
                    finish();
                }

            }
        });
       new Thread(){
           @Override
           public void run() {
               super.run();
               initData();
           }
       }.start();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100&&resultCode==RESULT_OK){
            String code =  data.getStringExtra("code");

            if (!TextUtils.isEmpty(code)){
                Intent intent = new Intent();
                intent.putExtra("code",code);
                setResult(RESULT_OK,intent);
                finish();
            }
        }
    }
    private void initData() {
        try {
            InputStream is = getAssets().open("city.json");
            InputStreamReader inputStreamReader=new InputStreamReader(is,"utf-8");
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String line;
            StringBuilder stringBuilder=new StringBuilder();
            while ((line=bufferedReader.readLine())!=null){
                stringBuilder.append(line);
            }
            bufferedReader.close();
            inputStreamReader.close();
            Gson gson =  new Gson();
            List<City> list = gson.fromJson(stringBuilder.toString(),
                    new TypeToken<List<City>>(){}.getType());
            for (int i = 0; i < list.size(); i++) {
                int pid =  list.get(i).pid;
                if (pid==0){
                    citys.add(list.get(i));
                }
            }

        } catch (IOException e) {

        }
        handler.sendEmptyMessage(0);
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:

                    mCollAdapter.notifyDataSetChanged();
                    break;
            }
        }
    };
}
