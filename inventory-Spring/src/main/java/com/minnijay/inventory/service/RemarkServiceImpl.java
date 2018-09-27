package com.minnijay.inventory.service;

import com.minnijay.inventory.repository.Remark;
import com.minnijay.inventory.repository.RemarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

@Service
public class RemarkServiceImpl implements RemarkService {

    private final RemarkRepository remarkRepository;

    @Autowired
    public RemarkServiceImpl(RemarkRepository remarkRepository) {
        this.remarkRepository = remarkRepository;
    }

    @Override
    public Remark save(Remark remark) {
        return remarkRepository.save(remark);
    }

    @Override
    public List<Remark> save(Remark... remarks) {
        return Arrays.stream(remarks).map(r -> remarkRepository.save(r)).collect(Collectors.toList());
    }

    @Override
    public List<Remark> findAll() {
        return remarkRepository.findAll();
    }

    @Override
    public Remark findById(int id) {
        return remarkRepository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        remarkRepository.deleteById(id);
    }


}
