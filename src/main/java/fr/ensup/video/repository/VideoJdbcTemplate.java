package fr.ensup.video.repository;

import fr.ensup.video.mapper.VideoMapper;
import fr.ensup.video.model.Video;
import fr.ensup.video.repository.IDao;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class VideoJdbcTemplate implements IDao<Video>{

    private  DataSource dataSource;
    private  JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Video get(long id) {
        String query = "select * from video where id=" + id;
        return jdbcTemplate.queryForObject(query, new VideoMapper());
    }

    @Override
    public void save(Video video) {
        String query = "insert into video (title, type) values (?,?)";
        jdbcTemplate.update(query, video.getTitle(), video.getType());
    }

    @Override
    public void update(Video video) {
    }

    @Override
    public List<Video> getAll() {
        String query = "select * from video";
        return jdbcTemplate.query(query, new VideoMapper());
    }
}