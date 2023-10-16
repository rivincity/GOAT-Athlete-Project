package com.example.customadapterproject;

public class goat {
    String sport;
    String name;
    int age;
    int championships;
    int years;
    String accolades;
    String thoughts;
    int image;

    public goat(String n, String s, int a, int c, int y, String acc, String t, int i) {
        name = n;
        sport = s;
        age = a;
        championships = c;
        years = y;
        accolades = acc;
        thoughts = t;
        image = i;
    }
    public String getName()
    {
        return name;
    }
    public String getSport()
    {
        return sport;
    }
    public int getAge()
    {
        return age;
    }
    public int getChamps()
    {
        return championships;
    }
    public int getYears()
    {
        return years;
    }
    public String getAccolades()
    {
        return accolades;
    }
    public String getThoughts()
    {
        return thoughts;
    }
    public int getImage()
    {
        return image;
    }
}
