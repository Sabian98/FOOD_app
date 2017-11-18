package com.example.taseef_pc.food2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class donateActivity extends AppCompatActivity {
    Button delete,search;
    private String urlEntryArray="http://192.168.1.103/xnapi/movie/addDonors";
    EditText name,location,no_person,contact,date;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        delete= (Button) findViewById(R.id.button4);
        search= (Button) findViewById(R.id.button5);


        name= (EditText) findViewById(R.id.editText);
        location= (EditText) findViewById(R.id.editText2);
        contact= (EditText) findViewById(R.id.editText3);
        no_person=(EditText) findViewById(R.id.editText6);
        date=(EditText) findViewById(R.id.editText7);

        delete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent=new  Intent(getApplicationContext(),delete_donate.class);
                startActivity(intent);
            }
        });

        search.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                do_entry();
                do_search();
            }
        });








    }


    void do_entry()
    {

        StringRequest request = new StringRequest(Request.Method.POST, urlEntryArray, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                System.out.println(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parameters  = new HashMap<String, String>();
                parameters.put("name",name.getText().toString());
                parameters.put("location",location.getText().toString());
                parameters.put("contact",contact.getText().toString());
                parameters.put("no_person",no_person.getText().toString());
                parameters.put("date",date.getText().toString());

                return parameters;
            }
        };
        requestQueue.add(request);
    }


    void  do_search()
    {




    }
}

