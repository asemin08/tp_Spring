package fr.ensup.video;

import fr.ensup.video.model.Video;
import fr.ensup.video.repository.VideoJdbcTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.*;

public class VideoLauncher {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        VideoJdbcTemplate videoJdbcTemplate = (VideoJdbcTemplate) context.getBean("videoJdbcTemplate");

       Video video =  new Video(1,"Matrix","film");
        videoJdbcTemplate.save(video);
        System.out.println("Une video à été crée : " + video);

        System.out.println(videoJdbcTemplate.get(1));
        System.out.println(videoJdbcTemplate.getAll());

       /* //1- Ouverture de connexion avec jpa
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
        emf.close();*/
    }
}