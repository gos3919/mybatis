package com.qf.dao;

import com.qf.pojo.Classes;

import java.util.List;

public interface ClassesDao {
    List<Classes> findAll(Integer id);
}
