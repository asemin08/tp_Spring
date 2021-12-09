package fr.ensup.video;

import fr.ensup.video.model.Video;
import fr.ensup.video.model.VideoLabel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class VideoLauncher {
    public static void main(String[] args) {
       //1- Ouverture de connexion avec jpa
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("video-reco-jpa");
        EntityManager em = emf.createEntityManager();

        //2- Ouverture d'une transaction

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        //3 Instantiation d'une video
        Video video = new Video("toto", "img");
        VideoLabel videoLabel = new VideoLabel("action");
        VideoLabel videoLabel2 = new VideoLabel("horreur");
        VideoLabel videoLabel3 = new VideoLabel("comedie");

        Set<VideoLabel> videoLabels = new HashSet<VideoLabel>();

        videoLabels.add(videoLabel);
        videoLabels.add(videoLabel2);
        videoLabels.add(videoLabel3);
        video.setVideoLabels(videoLabels);


//        video.getVideoLabels().add(videoLabel);
//        video.getVideoLabels().add(videoLabel2);
//        video.getVideoLabels().add(videoLabel3);


        //4-Persitionc de l'objet relationnel
        em.persist(videoLabel);
        em.persist(videoLabel2);
        em.persist(videoLabel3);
        em.persist(video);

        //5. Commit de la transation

        transaction.commit();

        // 6- fermeture de l'unité de travail jpa

        em.close();
        emf.close();
    }
}