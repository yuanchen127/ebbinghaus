package org.ike.ebbinghaus.service;

import org.ike.ebbinghaus.entity.Cycle;

import java.util.List;

public interface CycleService {
    int deleteByPrimaryKey(Integer id);

    int insert(Cycle record);

    int insertSelective(Cycle record);

    Cycle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cycle record);

    int updateByPrimaryKey(Cycle record);

    List<Cycle> listCycle();
}
