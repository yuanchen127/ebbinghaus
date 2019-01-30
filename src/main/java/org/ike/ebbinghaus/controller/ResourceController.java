package org.ike.ebbinghaus.controller;

import org.ike.ebbinghaus.entity.Resource;
import org.ike.ebbinghaus.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(@RequestBody Resource resource) {
        return String.valueOf(resourceService.insert(resource));
    }

    @RequestMapping(value="/sql",method = RequestMethod.POST)
    public List selectDefined(String sql) {
        return resourceService.selectBySql(sql);
    }
}
