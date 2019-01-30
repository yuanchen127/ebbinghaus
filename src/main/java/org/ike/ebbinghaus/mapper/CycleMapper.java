package org.ike.ebbinghaus.mapper;

import org.ike.ebbinghaus.entity.Cycle;
import org.springframework.stereotype.Repository;

@Repository
public interface CycleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cycle record);

    int insertSelective(Cycle record);

    Cycle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cycle record);

    int updateByPrimaryKey(Cycle record);
}