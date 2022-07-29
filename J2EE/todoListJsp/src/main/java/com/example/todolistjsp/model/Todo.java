package com.example.todolistjsp.model;

import java.util.Date;

public class Todo {
    private String title;
    private  String description;
    private Date target_date;
    private int user_id;
    private boolean is_done;

    @Override
    public String toString() {
        return "Todo{" +
                " " + title +
                " " + description +
                " " + target_date +
                " " + user_id +
                " " + is_done +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTarget_date() {
        return target_date;
    }

    public void setTarget_date(Date target_date) {
        this.target_date = target_date;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public boolean isIs_done() {
        return is_done;
    }

    public void setIs_done(boolean is_done) {
        this.is_done = is_done;
    }

    public Todo(String title, String description, Date target_date, int user_id, boolean is_done) {
        this.title = title;
        this.description = description;
        this.target_date = target_date;
        this.user_id = user_id;
        this.is_done = is_done;
    }
}
