package fr.ensup.video.mapper;

import fr.ensup.video.model.Video;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VideoMapper implements RowMapper<Video> {

    @Override
    public Video mapRow(ResultSet rs, int rowNum) throws SQLException{
        return new Video(rs.getLong("id"),
                rs.getString("title"),
                rs.getString("type")
        );
    }
}