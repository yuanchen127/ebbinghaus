package org.ike.ebbinghaus.service;

import org.ike.ebbinghaus.entity.Resource;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ResourceService {
    int deleteByPrimaryKey(Integer id);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);

    List<Resource> listResource();

    List<Resource> test(String sql);
}
