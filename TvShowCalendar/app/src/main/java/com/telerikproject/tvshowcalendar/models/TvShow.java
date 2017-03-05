package com.telerikproject.tvshowcalendar.models;

public class TvShow implements ITvShow {

    private final String id;
    private final String name;
    private final String vote;
    private final String poster;

    public TvShow(String id, String name, String vote, String poster) {
        this.id = id;
        this.name = name;
        this.vote = vote;
        this.poster = poster;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getVote() {
        return vote;
    }

    @Override
    public String getPoster() {
        return poster;
    }
}
