package com.example.a11st_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    static RequestQueue requestQueue;
    private Map<String, String>map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.xeditText);
        textView = findViewById(R.id.xtextView);

        Button button = findViewById(R.id.xbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.a11st_app.MainRequest mainRequest = new com.example.a11st_app.MainRequest(responseListener);
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(mainRequest);
                println("요청 보냄");
            }
        });
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
    }

//    new Response.Listener<String>() {
//        @Override
//        public void onResponse(String response) {
//            println("응답 ->" + response);
//        }
//    },
//            new Response.ErrorListener() {
//        @Override
//        public void onErrorResponse(VolleyError error) {
//            println("에러 ->" + error.getMessage());
//        }
//    }

    Response.Listener<String> responseListener = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            try {
                JSONObject jsonObject = new JSONObject(response);
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public void makeRequest(Response.Listener<String> listener) {
        com.example.a11st_app.MainRequest mainRequest = new com.example.a11st_app.MainRequest(responseListener);
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        queue.add(mainRequest);
        println("요청 보냄");
    }
    public void println(String data) {
        textView.append(data + "\n");
    }

}