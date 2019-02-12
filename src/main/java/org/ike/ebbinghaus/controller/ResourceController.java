package org.ike.ebbinghaus.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.ike.ebbinghaus.dao.ResourceDao;
import org.ike.ebbinghaus.entity.Resource;
import org.ike.ebbinghaus.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/resource")
@Api(value="resource", tags = "记忆资源相关接口")
public class ResourceController {

    @Autowired
    private ResourceDao resourceDao;

    @Autowired
    private ResourceService resourceService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(@RequestBody Resource resource) {
        return String.valueOf(resourceDao.insert(resource));
    }

    @RequestMapping(value="/list", method = RequestMethod.GET)
    public List listResource() {
        return resourceDao.listResource();
    }


    @ApiOperation(value = "根据自定义sql查询记忆资源信息")
    @ApiImplicitParam(name = "sql", value = "自定义sql", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value="/sql",method = RequestMethod.POST)
    public List sql(String sql) {
        return resourceDao.sql(sql);
    }

    @RequestMapping(value = "/warn", method = RequestMethod.GET)
    public Resource getWarnResource() {
        return resourceService.getWarnResource();
    }

    @RequestMapping(value = "/warn/list", method = RequestMethod.GET)
    public List listWarnResource() {
        return resourceService.listWarnResources();
    }

}
