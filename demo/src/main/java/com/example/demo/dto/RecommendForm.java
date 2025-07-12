package com.example.demo.dto;

public class RecommendForm {
    private String weather;
    private String time;
    private String budget;
    private String foodKategori;

    public RecommendForm(String foodKategori, String budget, String time, String weather) {
        this.foodKategori = foodKategori;
        this.budget = budget;
        this.time = time;
        this.weather = weather;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getFoodKategori() {
        return foodKategori;
    }

    public void setFoodKategori(String foodKategori) {
        this.foodKategori = foodKategori;
    }
}
