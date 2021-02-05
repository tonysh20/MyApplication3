package com.example.myapplication;

public class book {


    private String name,author,description;
    private String image , noOfPages ,noOfReviews;
    private float rating;

    public float getRating() {
        return  rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public book(String name, String author, String description, String image, String noOfPages, String noOfReviews, float rating) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.image = image;
        this.noOfPages = noOfPages;
        this.noOfReviews = noOfReviews;
        this.rating=rating;
    }

    public book() {

    }

    public String getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(String noOfPages) {
        this.noOfPages = noOfPages;
    }

    public String getNoOfReviews() {
        return noOfReviews;
    }

    public void setNoOfReviews(String noOfReviews) {
        this.noOfReviews = noOfReviews;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
