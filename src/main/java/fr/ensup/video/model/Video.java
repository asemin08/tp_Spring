package fr.ensup.video.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "video")
public class Video {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private long id;
    private String title;
    private  String type;

    @OneToMany
    Set<VideoLabel> videoLabels = new HashSet<>();


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
                '}';
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
