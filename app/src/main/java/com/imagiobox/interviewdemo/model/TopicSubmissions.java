package com.imagiobox.interviewdemo.model;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TopicSubmissions implements Parcelable {

    @SerializedName("street-photography")
    @Expose
    private StreetPhotography streetPhotography;
    @SerializedName("film")
    @Expose
    private Film film;
    @SerializedName("wallpapers")
    @Expose
    private Wallpapers wallpapers;
    public final static Creator<TopicSubmissions> CREATOR = new Creator<TopicSubmissions>() {


        @SuppressWarnings({
                "unchecked"
        })
        public TopicSubmissions createFromParcel(android.os.Parcel in) {
            return new TopicSubmissions(in);
        }

        public TopicSubmissions[] newArray(int size) {
            return (new TopicSubmissions[size]);
        }

    };

    protected TopicSubmissions(android.os.Parcel in) {
        this.streetPhotography = ((StreetPhotography) in.readValue((StreetPhotography.class.getClassLoader())));
        this.film = ((Film) in.readValue((Film.class.getClassLoader())));
        this.wallpapers = ((Wallpapers) in.readValue((Wallpapers.class.getClassLoader())));
    }

    public TopicSubmissions() {
    }

    public StreetPhotography getStreetPhotography() {
        return streetPhotography;
    }

    public void setStreetPhotography(StreetPhotography streetPhotography) {
        this.streetPhotography = streetPhotography;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Wallpapers getWallpapers() {
        return wallpapers;
    }

    public void setWallpapers(Wallpapers wallpapers) {
        this.wallpapers = wallpapers;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(streetPhotography);
        dest.writeValue(film);
        dest.writeValue(wallpapers);
    }

    public int describeContents() {
        return 0;
    }

}