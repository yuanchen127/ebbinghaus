package org.ike.ebbinghaus.dao.impl;

import org.ike.ebbinghaus.dao.CycleDao;
import org.ike.ebbinghaus.entity.Cycle;
import org.ike.ebbinghaus.mapper.CycleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository(value="cycleDao")
public class CycleDaoImpl implements CycleDao {
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
        List<Cycle> list = cycleMapper.listCycle();
        return list == null ? new ArrayList<>() : list;
    }
}
