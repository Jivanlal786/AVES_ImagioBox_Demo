package com.imagiobox.interviewdemo.model;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wallpapers implements Parcelable {

    @SerializedName("status")
    @Expose
    private String status;
    public final static Creator<Wallpapers> CREATOR = new Creator<Wallpapers>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Wallpapers createFromParcel(android.os.Parcel in) {
            return new Wallpapers(in);
        }

        public Wallpapers[] newArray(int size) {
            return (new Wallpapers[size]);
        }

    };

    protected Wallpapers(android.os.Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Wallpapers() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(status);
    }

    public int describeContents() {
        return 0;
    }

}