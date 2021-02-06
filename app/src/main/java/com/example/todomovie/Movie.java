package com.example.todomovie;

public class Movie {
    int _id;
    String _name;
    public Movie(){   }

    public Movie(int id, String name){
        this._id = id;
        this._name = name;
    }

    public Movie(String name){
        this._name = name;
    }
    public int getID(){
        return this._id;
    }

    public void setID(int id){
        this._id = id;
    }

    public String getName(){
        return this._name;
    }

    public void setName(String name){
        this._name = name;
    }


}

