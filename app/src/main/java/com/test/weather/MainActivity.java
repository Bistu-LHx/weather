package com.test.weather;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity  {
    private Toolbar toolbar;
    private TextView tvTemp;
    private TextView tvDes;
    private TextView tvWind;
    private TextView tvHumidity;
    private TextView tvUpdate;
    private TextView tvCity;
    private ProgressDialog progressDialog;
    private RecyclerView recyclerView;
    private ForecastAdapter nextForecastAdapter;
    private List<Weather.DataDTO.ForecastDTO> nextWeather = new ArrayList<>();
    private SharedPreferences sp;
    private String code;
    private SharedPreferences spColl;
    private Button btnRefresh;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         code = getIntent().getStringExtra("code");
        initView();
        getWeather(code);
        findViewById(R.id.btnGO).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.edit().putString(code, "").apply();
                getWeather(code);
            }
        });
        btnRefresh =   findViewById(R.id.btnRefresh);
        btnRefresh      .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String coll = spColl.getString(code, "");
                if (TextUtils.isEmpty(name)){
                    return;
                }
                if (TextUtils.isEmpty(coll)){
                    spColl.edit().putString(code,name).apply();
                }else{
                    spColl.edit().putString(code,"").apply();
                }
                setColl();
            }
        });

        setColl();
    }

    public void setColl(){
        String coll = spColl.getString(code, "");
        if (TextUtils.isEmpty(coll)){
            btnRefresh.setText("关注");
        }else{
            btnRefresh.setText("已关注");
        }
    }

    private void initView() {
        sp = getSharedPreferences("weather",MODE_PRIVATE);
        spColl = getSharedPreferences("coll",MODE_PRIVATE);
        progressDialog = new ProgressDialog(this);
        toolbar =  findViewById(R.id.toolbar);
        tvTemp =  findViewById(R.id.tv_temp);
        tvDes =  findViewById(R.id.tv_des);
        tvWind =  findViewById(R.id.tv_wind);
        tvHumidity =  findViewById(R.id.tv_humidity);
        tvCity =  findViewById(R.id.tv_city);
        tvUpdate =  findViewById(R.id.tv_update);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        nextForecastAdapter = new ForecastAdapter(this, nextWeather);
        recyclerView.setAdapter(nextForecastAdapter);
        recyclerView.setFocusable(false);

    }



    public String name;
    private void showWeatherInfo(Weather weather) {
        Weather.CityInfoDTO cityInfo = weather.getCityInfo();
        Weather.DataDTO data = weather.getData();
        name = cityInfo.getCity();
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(cityInfo.getCitykey(), new Gson().toJson(weather));
        editor.apply();

        getSupportActionBar().setTitle(cityInfo.getCity() );
        tvTemp.setText(data.getWendu() +  " °C");

        tvWind.setText( "Pm25: " +data.getPm25());
        tvHumidity.setText("湿度: " +data.getShidu() + " %");
        String des = data.getGanmao();
        tvDes.setText("更新时间"+des);
        tvUpdate.setText(cityInfo.getUpdateTime());
        tvCity.setText(cityInfo.getParent()+" "+cityInfo.getCity());
        List<Weather.DataDTO.ForecastDTO> forecasts = data.getForecast();
        nextWeather.clear();
        nextWeather.addAll(forecasts);
        nextForecastAdapter.notifyDataSetChanged();
    }







    private void getWeather(String cityCode) {
       String weatherInfo =  sp.getString(cityCode, "");
       if (!TextUtils.isEmpty(weatherInfo)){

           final Weather weather =  new Gson().fromJson(weatherInfo,Weather.class);
           if (weather != null && 200==weather.getStatus()) {
               showWeatherInfo(weather);
           } else {
               sp.edit().putString(cityCode, "").apply();
               getWeather(cityCode);
           }
           return;
       }
        progressDialog.show();
        String weatherUrl = "http://t.weather.itboy.net/api/weather/city/"+cityCode;

        HttpUtil.sendOkHttpRequest(weatherUrl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                progressDialog.dismiss();
            }


            @Override
            public void onResponse(Call call, Response response) throws IOException {
                progressDialog.dismiss();
                final String responseText = response.body().string();
                Log.e("tag",responseText);
                if (response.isSuccessful()){
                   runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            final Weather weather =  new Gson().fromJson(responseText,Weather.class);
                            if (weather != null && 200==weather.getStatus()) {
                                showWeatherInfo(weather);
                            } else {
                                Toast.makeText(MainActivity.this, weather.getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }else{
                }

            }
        });
    }
}
