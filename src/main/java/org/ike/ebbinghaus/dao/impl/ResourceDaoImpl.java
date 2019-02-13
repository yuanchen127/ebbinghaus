package org.ike.ebbinghaus.dao.impl;

import org.ike.ebbinghaus.dao.ResourceDao;
import org.ike.ebbinghaus.entity.Resource;
import org.ike.ebbinghaus.mapper.ResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository(value="resourceDao")
public class ResourceDaoImpl implements ResourceDao {
    @Autowired
    private ResourceMapper resourceMapper;

    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    public int insert(Resource record) {
        return resourceMapper.insert(record);
    }

    public int insertSelective(Resource record) {
        return 0;
    }

    public Resource selectByPrimaryKey(Integer id) {
        return null;
    }

    public int updateByPrimaryKeySelective(Resource record) {
        return 0;
    }

    public int updateByPrimaryKey(Resource record) {
        return 0;
    }

    public List<Resource> listResource() {
        List<Resource> list = resourceMapper.listResource();
        return list == null ? new ArrayList<>() : list;
    }

    public List<Resource> select(String sql) {
        List<Resource> list = resourceMapper.select(sql);
        return list == null ? new ArrayList<>() : list;
    }
}
