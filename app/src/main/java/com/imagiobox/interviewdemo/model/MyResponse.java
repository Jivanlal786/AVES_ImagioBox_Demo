package com.imagiobox.interviewdemo.model;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MyResponse implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("promoted_at")
    @Expose
    private String promotedAt;
    @SerializedName("width")
    @Expose
    private int width;
    @SerializedName("height")
    @Expose
    private int height;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("blur_hash")
    @Expose
    private String blurHash;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("alt_description")
    @Expose
    private String altDescription;
    @SerializedName("urls")
    @Expose
    private Urls urls;
    @SerializedName("links")
    @Expose
    private Links links;
    @SerializedName("likes")
    @Expose
    private int likes;
    @SerializedName("liked_by_user")
    @Expose
    private boolean likedByUser;
    @SerializedName("current_user_collections")
    @Expose
    private List<Object> currentUserCollections = null;
    @SerializedName("sponsorship")
    @Expose
    private Object sponsorship;
    @SerializedName("topic_submissions")
    @Expose
    private TopicSubmissions topicSubmissions;
    @SerializedName("user")
    @Expose
    private User user;
    public final static Creator<MyResponse> CREATOR = new Creator<MyResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public MyResponse createFromParcel(android.os.Parcel in) {
            return new MyResponse(in);
        }

        public MyResponse[] newArray(int size) {
            return (new MyResponse[size]);
        }

    };

    protected MyResponse(android.os.Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.promotedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.width = ((int) in.readValue((int.class.getClassLoader())));
        this.height = ((int) in.readValue((int.class.getClassLoader())));
        this.color = ((String) in.readValue((String.class.getClassLoader())));
        this.blurHash = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.altDescription = ((String) in.readValue((String.class.getClassLoader())));
        this.urls = ((Urls) in.readValue((Urls.class.getClassLoader())));
        this.links = ((Links) in.readValue((Links.class.getClassLoader())));
        this.likes = ((int) in.readValue((int.class.getClassLoader())));
        this.likedByUser = ((boolean) in.readValue((boolean.class.getClassLoader())));
        in.readList(this.currentUserCollections, (java.lang.Object.class.getClassLoader()));
        this.sponsorship = ((Object) in.readValue((Object.class.getClassLoader())));
        this.topicSubmissions = ((TopicSubmissions) in.readValue((TopicSubmissions.class.getClassLoader())));
        this.user = ((User) in.readValue((User.class.getClassLoader())));
    }

    public MyResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPromotedAt() {
        return promotedAt;
    }

    public void setPromotedAt(String promotedAt) {
        this.promotedAt = promotedAt;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBlurHash() {
        return blurHash;
    }

    public void setBlurHash(String blurHash) {
        this.blurHash = blurHash;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAltDescription() {
        return altDescription;
    }

    public void setAltDescription(String altDescription) {
        this.altDescription = altDescription;
    }

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public boolean isLikedByUser() {
        return likedByUser;
    }

    public void setLikedByUser(boolean likedByUser) {
        this.likedByUser = likedByUser;
    }

    public List<Object> getCurrentUserCollections() {
        return currentUserCollections;
    }

    public void setCurrentUserCollections(List<Object> currentUserCollections) {
        this.currentUserCollections = currentUserCollections;
    }

    public Object getSponsorship() {
        return sponsorship;
    }

    public void setSponsorship(Object sponsorship) {
        this.sponsorship = sponsorship;
    }

    public TopicSubmissions getTopicSubmissions() {
        return topicSubmissions;
    }

    public void setTopicSubmissions(TopicSubmissions topicSubmissions) {
        this.topicSubmissions = topicSubmissions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(promotedAt);
        dest.writeValue(width);
        dest.writeValue(height);
        dest.writeValue(color);
        dest.writeValue(blurHash);
        dest.writeValue(description);
        dest.writeValue(altDescription);
        dest.writeValue(urls);
        dest.writeValue(links);
        dest.writeValue(likes);
        dest.writeValue(likedByUser);
        dest.writeList(currentUserCollections);
        dest.writeValue(sponsorship);
        dest.writeValue(topicSubmissions);
        dest.writeValue(user);
    }

    public int describeContents() {
        return 0;
    }

}