package org.ike.ebbinghaus.dao;

import org.ike.ebbinghaus.entity.Resource;

import java.util.List;

public interface ResourceDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);

    List<Resource> listResource();

    List<Resource> select(String sql);
}
