package org.ike.ebbinghaus.service.impl;

import org.ike.ebbinghaus.dao.ResourceDao;
import org.ike.ebbinghaus.entity.Resource;
import org.ike.ebbinghaus.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "resourceService")
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceDao resourceDao;

    @Override
    public Resource getWarnResource() {
        String sql = "SELECT * FROM RESOURCE ORDER BY LAST_TIME ASC LIMIT 0,1";
        List<Resource> resultList = null;
        try {
            resultList = resourceDao.sql(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (resultList == null || resultList.isEmpty()) {
            return null;
        } else {
            return resultList.get(0);
        }
    }

    @Override
    public List<Resource> listWarnResources() {
        String sql = "SELECT * FROM RESOURCE ORDER BY LAST_TIME ASC";
        List<Resource> resultList = new ArrayList<>();
        try {
            resultList = resourceDao.sql(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
