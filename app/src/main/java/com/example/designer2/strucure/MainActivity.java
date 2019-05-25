package com.example.designer2.strucure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.List;


import static android.support.v7.widget.LinearLayoutManager.*;

public class MainActivity extends AppCompatActivity {
    List<videoModel> videolist;
    RecyclerView rv;
    String BASE_URL = "http://itelc.com/wbs/wp-json/yacrest/v1/posts/?limit=20";
    JsonArrayRequest request;
    RecyclerviewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rec);
        requestData(BASE_URL);

    }

    public void requestData(String BASE_URL){
        StringRequest request = new StringRequest(Request.Method.GET,BASE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                videolist = jsonparser.parseData(response);
                 adapter  = new RecyclerviewAdapter(MainActivity.this,videolist);
                rv.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
                rv.setAdapter(adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error.getMessage().toString(),Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }
}
