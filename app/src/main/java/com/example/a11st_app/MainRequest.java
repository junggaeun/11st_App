package com.example.a11st_app;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

public class MainRequest extends StringRequest {
    private Map<String, String>map;
    final static private String url = "https://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=da5307e8cb6da4c5bd5b3b7ac1aa7e16&targetDt=20211111";

    public MainRequest(Response.Listener<String> listener) {
        super(Method.GET, url, listener, null);


    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
