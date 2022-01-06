package cn.swu.edu;


public class Film {

    private int id;
    private String film;
    private String editor;
    private String actor;
    private String pics;
    private String type;
    private String time;
    private String review;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getFilm() {
        return film;
    }
    public void setFilm(String film) {
        this.film = film;
    }
    public String getEditor() {
        return editor;
    }
    public void setEditor(String editor) {
        this.editor = editor;
    }
    public String getActor(){return actor;}

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
   public String getTime(){return time;}

    public void setTime(String time) {
        this.time = time;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getPics(){return this.pics;}
    public void setPics(String pics) {this.pics = pics;}



}

