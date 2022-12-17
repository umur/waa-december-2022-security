package edu.miu.mae.controller;

import edu.miu.mae.service.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



public  class BaseController<T,H> implements BasicControllerInterface<T,H>{
    @Autowired
    public BasicService<T,H> bs ;

    @Override
    @GetMapping
    public List<H> findAll() {
        return bs.getAll();
    }

    @Override
    @PostMapping
    public void save(@RequestBody  H t) {
        bs.save(t);
    }

    @Override
    @PutMapping("/{id}")
    public void update(@RequestBody H t, @PathVariable int id) {
        bs.update(t,id);
    }

    @Override
    @GetMapping("/{id}")
    public H findById(@PathVariable int id) {
       return bs.getById(id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
         bs.delete(id);
    }

}
