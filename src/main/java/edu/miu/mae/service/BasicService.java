package edu.miu.mae.service;

import edu.miu.mae.entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BasicService<T,H> {


    void save(H ad);
    H getById(int id);
    void update(H ad,int id);
    void delete(int id);

    List<H> getAll();
}
