package net.io.kino.controller.dto;

import net.io.kino.model.Movie;
import net.io.kino.model.MovieCategory;

import java.time.Duration;

public class MovieRequest extends Movie {
    private MovieCategory category;
    private String title;
    private Duration duration;
    private String description;
    private String director;
    private Integer ageRestriction;

    @Override
    public MovieCategory getCategory() {
        return category;
    }

    @Override
    public void setCategory(MovieCategory category) {
        this.category = category;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Duration getDuration() {
        return duration;
    }

    @Override
    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getDirector() {
        return director;
    }

    @Override
    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public Integer getAgeRestriction() {
        return ageRestriction;
    }

    @Override
    public void setAgeRestriction(Integer ageRestriction) {
        this.ageRestriction = ageRestriction;
    }
}
