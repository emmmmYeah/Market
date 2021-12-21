package cn.swu.edu;


public class Film {//网页上传元素，如果是电影：

    private int id;
    private String film;
    private String editor;
    private String actor;
    private String pics;


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
    public String geteditor() {
        return editor;
    }
    public void seteditor(String editor) {
        this.editor = editor;
    }
    public String getactor() {
        return actor;
    }
    public void setactor(String actor) {
        this.actor = actor;
    }
    public String getPics(){return this.pics;}
    public void setPics(String pics) {this.pics = pics;}


}

