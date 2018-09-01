package com.clue.raldeskrisnu.clue.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.xml.transform.Result;

public class ResultApi {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("user_id")
    @Expose
    private Integer userId;

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("lat")
    @Expose
    private Float lat;

    @SerializedName("lng")
    @Expose
    private Float lng;

    @SerializedName("progress")
    @Expose
    private String progress;

    @SerializedName("image_url")
    @Expose
    private String imageUrl;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("kelurahan")
    @Expose
    private String kelurahan;

    @SerializedName("results")
    @Expose
    private List<ResultApi> results = null;

    public ResultApi() {
    }

    public ResultApi(Integer id, Integer userId, String username, Float lat, Float lng, String progress, String imageUrl, String description, String kelurahan) {
        super();
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.lat = lat;
        this.lng = lng;
        this.progress = progress;
        this.imageUrl = imageUrl;
        this.description = description;
        this.kelurahan = kelurahan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLng() {
        return lng;
    }

    public void setLng(Float lng) {
        this.lng = lng;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public List<ResultApi> getResults() {
        return results;
    }
    public void setResults(List<ResultApi> results) {
        this.results = results;
    }
}
