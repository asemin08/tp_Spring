package fr.ensup.video;

import fr.ensup.video.model.Video;

import javax.persistence.*;

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

        //4-Persitionc de l'objet relationnel

        em.persist(video);

        //5. Commit de la transation

        transaction.commit();

        // 6- fermeture de l'unité de travail jpa

        em.close();
        emf.close();
    }
}