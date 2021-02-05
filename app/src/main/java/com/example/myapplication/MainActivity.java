package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {


RecyclerView recyclerView;
List<book> arraylist;
public RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestQueue=Volley.newRequestQueue(getApplicationContext());
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        arraylist=new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_fragment);


        loadList();
        recyclerView=findViewById(R.id.RECYCLERVIEW);
        Book_RecyclerAdaptor adaptor = new Book_RecyclerAdaptor(getApplicationContext(),arraylist);
        recyclerView.setAdapter(adaptor);

        adaptor.notifyDataSetChanged();


    }


    private void loadList() {
        final String JSON_URL = "https://run.mocky.io/v3/e36cc68e-5e78-4f11-950b-fc6570bc5d03";

        //creating a string request to send request to the url
        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, JSON_URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //hiding the progressbar after completion and showing list view

                        // Showing json data in log monitor
                        Log.d("json", response.toString());
                        try {
                            //we have the array named hero inside the object
                            //so here we are getting that json array
                            JSONArray jsonArray = response.getJSONArray("items");




                            //now looping through all the elements of the json array
                            for (int i = 0; i < jsonArray.length(); i++) {
                                //getting the json object of the particular index inside the array
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                //creating a hero object and giving them the values from json object

                                book newBook = new book();
                                JSONObject vol=jsonObject.getJSONObject("volumeInfo");
                                JSONArray authors=vol.getJSONArray("authors");
                                JSONObject img=vol.getJSONObject("imageLinks");

                                newBook.setImage(img.getString("thumbnail"));
                                System.out.println(newBook.getImage());


                                newBook.setName(vol.getString("title"));
                                System.out.println(vol.getString("title"));
                               newBook.setAuthor(authors.getString(0));

//                                System.out.println( vol.getString("averageRating").equals("ERROR"));
//                                if(vol.optJSONObject("averageRating")==null)
//                                {
//                                    System.out.println("null"+ vol.getString("averageRating").equals("null"));
//
//                                    System.out.println(newBook.getRating());
//                                }
//                                else{  newBook.setRating(0);
//                                      newBook.setRating(BigDecimal.valueOf(vol.getDouble("averageRating")).floatValue());
//                                    System.out.println(newBook.getRating());
//                                }


                                  // if(vol.getString("averageRating") == 0)
                               //    {  newBook.setRating((BigDecimal.valueOf(vol.getDouble("averageRating")).floatValue()));}

                             //      else  newBook.setRating(0);
                             //      newBook.setNoOfReviews(vol.getString("ratingsCount"));
                             //  newBook.setNoOfPages(vol.getString("pageCount"));

                                //adding the json data to list
                                arraylist.add(newBook);
                            }
                            Book_RecyclerAdaptor adaptor = new Book_RecyclerAdaptor(getApplicationContext(),arraylist);
                            recyclerView.setAdapter(adaptor);
                            LinearLayoutManager X = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                            recyclerView.setLayoutManager(X);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //displaying the error in toast if occurred
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        //adding the string request to request queue
        requestQueue.add(jsonObjectRequest);
    }

}