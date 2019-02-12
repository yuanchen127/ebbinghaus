package org.ike.ebbinghaus.common;


import org.ike.ebbinghaus.dao.CycleDao;
import org.ike.ebbinghaus.dao.ResourceDao;
import org.ike.ebbinghaus.entity.Cycle;
import org.ike.ebbinghaus.entity.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Ebbinghaus {

    @Autowired
    private CycleDao cycleDao;

    @Autowired
    private ResourceDao resourceDao;

    private static final List<Cycle> cycleList = new ArrayList<>();
    /*static{
        cycleList.add(new Cycle(Calendar.MINUTE, -20, 58.20));
        cycleList.add(new Cycle(Calendar.HOUR, -1, 44.20));
        cycleList.add(new Cycle(Calendar.HOUR, -8, 35.80));
        cycleList.add(new Cycle(Calendar.DAY_OF_YEAR, -1, 33.70));
        cycleList.add(new Cycle(Calendar.DAY_OF_YEAR, -2, 27.80));
        cycleList.add(new Cycle(Calendar.DAY_OF_YEAR, -6, 25.40));
        cycleList.add(new Cycle(Calendar.MONTH, -1, 21.10));
    }*/

    {
        if (cycleList.isEmpty()) {
            List<Cycle> cycles = cycleDao.listCycle();
            if (cycles != null && !cycles.isEmpty()) {
                cycleList.addAll(cycleDao.listCycle());
            }
        }
    }

    public List getCycleList() {
        return cycleList;
    }

    public List flushCycleList() {
        List<Cycle> cycles = cycleDao.listCycle();
        cycleList.addAll(cycles);
        return cycleList;
    }

    public int getIntervalCycle(Resource resource) {
        int interval = 0;
        Date firstTime = resource.getFirstTime();
        for (Cycle cycle : cycleList) {
            Calendar now = Calendar.getInstance();
            now.add(cycle.getUnit(), cycle.getIncrement());
            Calendar last = null;
            if (resource.getLastTime() != null) {
                last = Calendar.getInstance();
                last.setTime(resource.getLastTime());
                last.add(cycle.getUnit(), cycle.getIncrement());
            }
            if ((last!=null && last.before(now) && now.after(firstTime)) || (last==null && now.after(firstTime))) {
                interval ++;
            }
        }
        return interval;
    }

    public void memory(Resource resource, boolean memory) {
        Date now = new Date();
        if (memory) {
            resource.setLastTime(now);
        } else {
            resource.setFirstTime(now);
        }
        resource.setMemory(String.valueOf(memory));
    }
}
