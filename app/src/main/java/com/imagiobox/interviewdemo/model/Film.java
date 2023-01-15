package com.imagiobox.interviewdemo.model;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Film implements Parcelable {

    @SerializedName("status")
    @Expose
    private String status;
    public final static Creator<Film> CREATOR = new Creator<Film>() {

        @SuppressWarnings({"unchecked"})
        public Film createFromParcel(android.os.Parcel in) {
            return new Film(in);
        }

        public Film[] newArray(int size) {
            return (new Film[size]);
        }

    };

    protected Film(android.os.Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Film() {
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

    @Override
    public String toString() {
        return "Film{" +
                "status='" + status + '\'' +
                '}';
    }
}