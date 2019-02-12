package org.ike.ebbinghaus.service.impl;

import org.ike.ebbinghaus.entity.Cycle;
import org.ike.ebbinghaus.mapper.CycleMapper;
import org.ike.ebbinghaus.service.CycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="cycleService")
public class CycleServiceImpl implements CycleService {

    @Autowired
    private CycleMapper cycleMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return cycleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Cycle record) {
        return cycleMapper.insert(record);
    }

    @Override
    public int insertSelective(Cycle record) {
        return cycleMapper.insertSelective(record);
    }

    @Override
    public Cycle selectByPrimaryKey(Integer id) {
        return cycleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Cycle record) {
        return cycleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Cycle record) {
        return cycleMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Cycle> listCycle() {
        return cycleMapper.listCycle();
    }
}
