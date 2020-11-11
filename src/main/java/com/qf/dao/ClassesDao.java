package com.qf.dao;

import com.qf.pojo.Classes;

import java.util.List;

public interface ClassesDao {
    List<Classes> findAll(Integer id);
    List<Classes> selectAll();
    int insertById(Classes classes);
    int updateClasses(Classes classes);
}
