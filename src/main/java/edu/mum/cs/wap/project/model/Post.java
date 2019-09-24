package edu.mum.cs.wap.project.model;

import javax.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;
    private String title;
    private String description;
//mapping user
    @ManyToOne(optional = false)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    public Post( String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Post(){}

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
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
}
