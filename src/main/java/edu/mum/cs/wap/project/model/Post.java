package edu.mum.cs.wap.project.model;

import javax.persistence.*;
import java.time.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;
    private String description;
    private String postPic;
    private boolean status;


    public Post(){}

    public Post(String description) {
        this.description = description;
    }

    public Post(String description, String postPic) {
        this.description = description;
        this.postPic = postPic;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPostPic() {
        return postPic;
    }

    public void setPostPic(String postPic) {
        this.postPic = postPic;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}