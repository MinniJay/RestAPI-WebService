package com.minnijay.inventory.controller;

import com.minnijay.inventory.repository.Remark;
import com.minnijay.inventory.service.RemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/remark")
public class RemarkController {

    private final RemarkService remarkService;

    @Autowired
    public RemarkController(RemarkService remarkService) {
        this.remarkService = remarkService;
    }

    @PostMapping("/create")
    public Remark create(@RequestBody Remark remark){
        return remarkService.save(remark);
    }

    @GetMapping("/findAll")
    public List<Remark> findAll(){
        return remarkService.findAll();
    }

    @GetMapping("/findById")
    public Remark findById(@RequestParam int id){
        return remarkService.findById(id);
    }

    @DeleteMapping("/delete")
    public void deleteById(int id){
        remarkService.delete(id);
    }
}
