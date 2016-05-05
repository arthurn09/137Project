package com.example.arthurnguyen.cmpe137project;

import android.text.BoringLayout;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://arthurnguyen.net16.net/Register.php";
    private Map<String, String> params;

    public RegisterRequest(String username, String password, String design1, String design2,
                           String design3, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
        params.put("design1", design1);
        params.put("design2", design2);
        params.put("design3", design3);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
