package org.ike.ebbinghaus.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ike.ebbinghaus.dao.CycleDao;
import org.ike.ebbinghaus.service.CycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/cycle")
@Api(value="cycle", tags = "记忆周期相关接口")
public class CycleController {

    @Autowired
    private CycleDao cycleDao;

    @Autowired
    private CycleService cycleService;

    @ApiOperation("查询记忆周期列表")
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public List listCycle() {
        return cycleDao.listCycle();
    }

    @ApiOperation("记忆周期数据初始化")
    @RequestMapping(value="/init", method = RequestMethod.GET)
    public int init() {
        return cycleService.init();
    }

    @RequestMapping(value="/delete", method = RequestMethod.GET)
    public int sql() {
        String sql = "select * from cycle";
        Object count = cycleDao.sql(sql);
        return (Integer) count;
    }
}
