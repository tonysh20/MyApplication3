package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Response;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import org.json.JSONObject;

import java.util.*;

public class Book_RecyclerAdaptor extends RecyclerView.Adapter<Book_RecyclerAdaptor.BookViewHolder> {

    private List<book> mlist;

    public Book_RecyclerAdaptor(Response.Listener<JSONObject> listener, List<book> list) {
        mlist=list;
        notifyDataSetChanged();
    }

    public Book_RecyclerAdaptor(Context baseContext, List<book> arraylist) {
        mlist=arraylist;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new BookViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bookitem,parent,false));
    }



    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        book mCurrent = mlist.get(position);

        holder.AuthorName.setText(mCurrent.getAuthor());
        holder.BookName.setText(mCurrent.getName());
        holder.NoOfPages.setText(mCurrent.getNoOfPages());
        holder.NoOfReviews.setText(mCurrent.getNoOfReviews());
            //   System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
      //  System.out.println((int) mCurrent.getRating());
        holder.BookRating.setNumStars((int) mCurrent.getRating());
        Picasso.get().load(mCurrent.getImage()).fit().centerInside()
                .into(holder.BookPicture
                        //, new Callback() {
                //   @Override
                 //   public void onSuccess() {
                  //      System.out.println("success");
                 //  }
                 //   @Override
                //    public void onError(Exception e) {

                 //  / }
              //  }
                        );

    }


    @Override
    public int getItemCount() {

        return mlist.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder   {

       public Book_RecyclerAdaptor bookAdaptor;
       public TextView BookName,AuthorName,NoOfPages,NoOfReviews;
       public ImageView BookPicture;
       public RatingBar BookRating;




        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            BookName = itemView.findViewById(R.id.txt_bookName);
            AuthorName = itemView.findViewById(R.id.txt_author);
            NoOfPages = itemView.findViewById(R.id.txt_noOfPages2);
            NoOfReviews = itemView.findViewById(R.id.txt_reviews);
            BookPicture = itemView.findViewById(R.id.pictureView);
            BookRating = itemView.findViewById(R.id.ratingBar);


         //   Description=itemView.findViewById(R.id.d);


        }



    }
}







