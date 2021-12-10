package fr.ensup.video.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.*;

@Entity
public class Video {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private long id;
    private String title;
    private  String type;

    @ManyToMany(cascade = CascadeType.ALL)
    Set<VideoLabel> videoLabels = new HashSet<>();

    @ManyToOne
    private User user;


    public Video(String title, String type) {
        this.title = title;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", videoLabels=" + videoLabels +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Video video = (Video) o;
        return id == video.id && Objects.equals(title, video.title) && Objects.equals(type, video.type) && Objects.equals(videoLabels, video.videoLabels) && Objects.equals(user, video.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, type, videoLabels, user);
    }

    public Video(long id, String title, String type) {
        this.id = id;
        this.title = title;
        this.type = type;
    }

    public Video() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<VideoLabel> getVideoLabels() {
        return videoLabels;
    }

    public void setVideoLabels(Set<VideoLabel> videoLabels) {
        this.videoLabels = videoLabels;
    }
}
