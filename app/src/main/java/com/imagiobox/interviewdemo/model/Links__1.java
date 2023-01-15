package com.imagiobox.interviewdemo.model;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links__1 implements Parcelable {

    @SerializedName("self")
    @Expose
    private String self;
    @SerializedName("html")
    @Expose
    private String html;
    @SerializedName("photos")
    @Expose
    private String photos;
    @SerializedName("likes")
    @Expose
    private String likes;
    @SerializedName("portfolio")
    @Expose
    private String portfolio;
    @SerializedName("following")
    @Expose
    private String following;
    @SerializedName("followers")
    @Expose
    private String followers;
    public final static Creator<Links__1> CREATOR = new Creator<Links__1>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Links__1 createFromParcel(android.os.Parcel in) {
            return new Links__1(in);
        }

        public Links__1[] newArray(int size) {
            return (new Links__1[size]);
        }

    };

    protected Links__1(android.os.Parcel in) {
        this.self = ((String) in.readValue((String.class.getClassLoader())));
        this.html = ((String) in.readValue((String.class.getClassLoader())));
        this.photos = ((String) in.readValue((String.class.getClassLoader())));
        this.likes = ((String) in.readValue((String.class.getClassLoader())));
        this.portfolio = ((String) in.readValue((String.class.getClassLoader())));
        this.following = ((String) in.readValue((String.class.getClassLoader())));
        this.followers = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Links__1() {
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(self);
        dest.writeValue(html);
        dest.writeValue(photos);
        dest.writeValue(likes);
        dest.writeValue(portfolio);
        dest.writeValue(following);
        dest.writeValue(followers);
    }

    public int describeContents() {
        return 0;
    }

}