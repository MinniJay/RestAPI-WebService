package com.minnijay.inventory.service;

import com.minnijay.inventory.repository.Remark;

import java.util.List;

public interface RemarkService {
    Remark save(Remark remark);

    List<Remark> save(Remark ... remarks);

    List<Remark> findAll();

    Remark findById(int id);

    void delete(int id);
}
