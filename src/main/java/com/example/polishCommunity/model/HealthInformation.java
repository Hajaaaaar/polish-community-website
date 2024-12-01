package com.example.polishCommunity.model;

public class HealthInformation {
    private String name;
    private String email;
    private String location;
    private Boolean q1registered;
    private String q2queries;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getLocation(){
        return location;
    }
    public void setLocation(String location){
        this.location = location;
    }
    public boolean isQ1registered(){
        return q1registered;
    }
    public void setQ1registered(boolean q1registered){
        this.q1registered = q1registered;
    }
    public String getQ2queries(){
        return q2queries;
    }
    public void setQ2queries(String q2queries){
        this.q2queries = q2queries;
    }
}
