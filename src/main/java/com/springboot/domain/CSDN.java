package com.springboot.domain;

public class CSDN {
    private int article_id;
    private int article_user_id;
    private String article_title;
    private String article_content;
    private int article_view_count;
    private int article_comment_count;
    private int article_like_count;
    private int article_is_comment;
    private int article_status;
    private int article_order;
    private String article_update_time;
    private String article_create_time;
    private String article_summary;

    public CSDN() {
        super();
    }

    public CSDN(String title) {
        article_title = title;
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public int getArticle_user_id() {
        return article_user_id;
    }

    public void setArticle_user_id(int article_user_id) {
        this.article_user_id = article_user_id;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_content() {
        return article_content;
    }

    public void setArticle_content(String article_content) {
        this.article_content = article_content;
    }

    public int getArticle_view_count() {
        return article_view_count;
    }

    public void setArticle_view_count(int article_view_count) {
        this.article_view_count = article_view_count;
    }

    public int getArticle_comment_count() {
        return article_comment_count;
    }

    public void setArticle_comment_count(int article_comment_count) {
        this.article_comment_count = article_comment_count;
    }

    public int getArticle_like_count() {
        return article_like_count;
    }

    public void setArticle_like_count(int article_like_count) {
        this.article_like_count = article_like_count;
    }

    public int getArticle_is_comment() {
        return article_is_comment;
    }

    public void setArticle_is_comment(int article_is_comment) {
        this.article_is_comment = article_is_comment;
    }

    public int getArticle_status() {
        return article_status;
    }

    public void setArticle_status(int article_status) {
        this.article_status = article_status;
    }

    public int getArticle_order() {
        return article_order;
    }

    public void setArticle_order(int article_order) {
        this.article_order = article_order;
    }

    public String getArticle_update_time() {
        return article_update_time;
    }

    public void setArticle_update_time(String article_update_time) {
        this.article_update_time = article_update_time;
    }

    public String getArticle_create_time() {
        return article_create_time;
    }

    public void setArticle_create_time(String article_create_time) {
        this.article_create_time = article_create_time;
    }

    public String getArticle_summary() {
        return article_summary;
    }

    public void setArticle_summary(String article_summary) {
        this.article_summary = article_summary;
    }
}
