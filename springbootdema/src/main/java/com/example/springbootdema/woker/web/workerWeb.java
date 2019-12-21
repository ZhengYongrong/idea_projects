package com.example.springbootdema.woker.web;

import com.example.springbootdema.woker.domain.worker;
import com.example.springbootdema.woker.service.workerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/worker")
public class workerWeb {
    @Autowired
    private workerService workerService;

    @GetMapping
    public worker finOne(Long id) {
        return workerService.findOne(id);
    }

    @PostMapping
    public void save(worker worker) {

        workerService.saveOrUpdate(worker);
    }

    @PutMapping
    public String update(worker worker) {
        //worker worker1=workerService.findOne(worker.getId());
        workerService.saveOrUpdate(worker);
        return "success";

    }

    @DeleteMapping
    public int delete(Long id) {
        worker worker = finOne(id);
        if (null != worker) {
            workerService.delete(worker);
            return 1;
        } else {
            return 0;
        }
    }
}
