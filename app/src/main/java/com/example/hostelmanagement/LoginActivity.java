package com.example.hostelmanagement;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    EditText emailEditText, passwordEditText;
    Volley requestQue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailEditText = findViewById(R.id.editTextEmail);
        passwordEditText = findViewById(R.id.editTextPassword);
    }
    public void login(View view) {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String loginUrl = "http://127.0.0.1/Login/login.php";
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("email", email);
            jsonObject.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, loginUrl, jsonObject,
                response -> {
                    try {
                        int status = response.getInt("status");
                        String message = response.getString("message");

                        if (status == 0) {
                            String fullName = response.getString("full_name");
                            Toast.makeText(getApplicationContext(), "Welcome, " + fullName, Toast.LENGTH_SHORT).show();
                            // Redirect to next activity or perform other actions
                            Intent register = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(register);
                        } else {
                            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                            Intent register = new Intent(getApplicationContext(),RegisterActivity.class);
                            startActivity(register);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, error -> {
                    Log.e("LoginError", "Error: " + error.getMessage());
                    Toast.makeText(getApplicationContext(), "Error occurred. Please try again.", Toast.LENGTH_SHORT).show();
                });

        Volley.newRequestQueue(getApplicationContext()).add(jsonObjectRequest);
    }
}