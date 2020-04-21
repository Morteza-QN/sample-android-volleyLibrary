package com.example.volleylibrary;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        StringRequest stringRequest =
                new StringRequest(StringRequest.Method.GET, "http://expertdevelopers.ir/api/v1/experts/student",
                                  new Response.Listener<String>() {
                                      @Override
                                      public void onResponse(String response) {
                                          Log.i(TAG, "onResponse: " + response);
                                          try {
                                              JSONArray     jsonArray = new JSONArray(response);
                                              List<Student> students  = new ArrayList<>();
                                              for (int i = 0; i < jsonArray.length(); i++) {
                                                  JSONObject studentJsonObject = jsonArray.getJSONObject(i);
                                                  Student    Student           = new Student();
                                                  Student.setId(studentJsonObject.getInt("id"));
                                                  Student.setFirst_name(studentJsonObject.getString("first_name"));
                                                  Student.setLast_name(studentJsonObject.getString("last_name"));
                                                  Student.setCourse(studentJsonObject.getString("course"));
                                                  Student.setScore(studentJsonObject.getInt("score"));
                                                  Student.setCreated_at(studentJsonObject.getString("created_at"));
                                                  Student.setUpdated_at(studentJsonObject.getString("updated_at"));
                                                  students.add(Student);
                                              }
                                              Log.i(TAG, "onResponse: students" + students.toString());
                                          }
                                          catch (JSONException e) {
                                              e.printStackTrace();
                                          }
                                      }
                                  }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i(TAG, "onErrorResponse: " + error.toString());
                    }
                });

        stringRequest.setTag(TAG);
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(5000, 3, 2));//waite timeOut
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        requestQueue.cancelAll(TAG);
    }
}
