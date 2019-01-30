package org.ike.ebbinghaus.service.impl;

import org.ike.ebbinghaus.entity.Resource;
import org.ike.ebbinghaus.mapper.ResourceMapper;
import org.ike.ebbinghaus.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "resourceService")
public class ResourceServiceImpl implements ResourceService {

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
        return resourceMapper.listResource();
    }
}
