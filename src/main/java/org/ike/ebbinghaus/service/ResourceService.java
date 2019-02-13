package org.ike.ebbinghaus.service;

import org.ike.ebbinghaus.entity.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="resourceService")
public interface ResourceService {

    Resource getWarnResource();

    List<Resource> listWarnResources();

    Resource getErrorResource();

    List<Resource> listErrorResources();
}
