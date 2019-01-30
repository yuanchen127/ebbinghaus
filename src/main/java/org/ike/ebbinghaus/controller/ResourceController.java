package org.ike.ebbinghaus.controller;

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
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(@RequestBody Resource resource) {
        return String.valueOf(resourceService.insert(resource));
    }

    @RequestMapping(value="/list")
    public List listResource() {
        return resourceService.listResource();
    }
}
