package org.ike.ebbinghaus.mapper;

import org.ike.ebbinghaus.entity.Cycle;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CycleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cycle record);

    int insertSelective(Cycle record);

    Cycle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cycle record);

    int updateByPrimaryKey(Cycle record);

    List<Cycle> listCycle();

    List<Cycle> select(String sql);
}