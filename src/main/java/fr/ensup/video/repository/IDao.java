package fr.ensup.video.repository;

import java.util.List;

public interface IDao<T> {
    T get(long id);
    void save(T t);
    void update(T t);
    List<T> getAll();
}
