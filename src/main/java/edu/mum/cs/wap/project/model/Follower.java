package edu.mum.cs.wap.project.model;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import java.util.Date;


public class Follower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "follower_userId", referencedColumnName = "userId")
    User follower;

    @Temporal(javax.persistence.TemporalType.DATE)
    Date date;

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }
}
