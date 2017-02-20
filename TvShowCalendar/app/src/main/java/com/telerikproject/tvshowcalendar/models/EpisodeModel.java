package com.telerikproject.tvshowcalendar.models;

public class EpisodeModel {
    private int id;
    private String url;
    private String name;
    private int season;
    private int number;
    private String airdate;
    private String airtime;
    private String airstamp;
    private int runtime;
    private ImageModel image;
    private String summary;
    private LinksModel _links;


    public EpisodeModel() {

    }

    public EpisodeModel(int id, String url, String name, int season,
                        int number, String airdate, String airtime,
                        String airstamp, int runtime, ImageModel image, String summary, LinksModel _links) {

    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public int getSeason() {
        return season;
    }

    public int getNumberOFEpisode() {
        return number;
    }

    public String getAirDate() {
        return airdate;
    }

    public String getAirTime() {
        return airtime;
    }

    public String getAirStamp() {
        return airstamp;
    }

    public int getRunTime() {
        return runtime;
    }

    public String getSummary() {
        return summary.substring(3, summary.length() - 4);
    }

    public ImageModel getImage() {
        return image;
    }

    public LinksModel getLinks() {
        return _links;
    }
}
