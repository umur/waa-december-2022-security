package edu.miu.mae.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BasicControllerInterface<T,H> {
    List<H> findAll();
    void save(H t);
    void update(H t, int id);

    H findById(int id);

    void delete(int id);
}
