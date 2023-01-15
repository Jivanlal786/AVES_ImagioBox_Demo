package com.imagiobox.interviewdemo.model;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StreetPhotography implements Parcelable {

    @SerializedName("status")
    @Expose
    private String status;
    public final static Creator<StreetPhotography> CREATOR = new Creator<StreetPhotography>() {


        @SuppressWarnings({
                "unchecked"
        })
        public StreetPhotography createFromParcel(android.os.Parcel in) {
            return new StreetPhotography(in);
        }

        public StreetPhotography[] newArray(int size) {
            return (new StreetPhotography[size]);
        }

    };

    protected StreetPhotography(android.os.Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
    }

    public StreetPhotography() {
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