package org.ike.ebbinghaus.common;


import org.ike.ebbinghaus.dao.CycleDao;
import org.ike.ebbinghaus.dao.ResourceDao;
import org.ike.ebbinghaus.entity.Cycle;
import org.ike.ebbinghaus.entity.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.*;

public class Ebbinghaus {

    @Autowired
    private CycleDao cycleDao;

    @Autowired
    private ResourceDao resourceDao;

    private static final List<Cycle> cycleList = new ArrayList<>();
    private static final double MIN_CAPACITY = 21.10;
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

    public Cycle getLastCycle(Resource resource) {
        if (cycleList.isEmpty()) {
            return null;
        }
        Collections.sort(cycleList, new Comparator<Cycle>() {
            @Override
            public int compare(Cycle c1, Cycle c2) {
                long firstTime = resource.getFirstTime().getTime();

                Calendar var1 = Calendar.getInstance();
                var1.setTime(resource.getLastTime());
                var1.add(c1.getUnit(), c1.getIncrement());

                Calendar var2 = Calendar.getInstance();
                var2.setTime(resource.getLastTime());
                var2.add(c2.getUnit(), c2.getIncrement());

                return Math.abs(firstTime - var1.getTimeInMillis()) >= Math.abs(firstTime - var2.getTimeInMillis()) ? 0 : -1;
            }
        });
        return cycleList.get(0);
    }

    public int getCycleInterval(Resource resource) {
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

    public Resource Mark(Resource resource, boolean memory) {
        Cycle lastCycle = getLastCycle(resource);
        if (lastCycle == null) {
            return resource;
        }
        if (memory) {
            double lastCapacity = lastCycle.getCapacity();
            if (lastCapacity != MIN_CAPACITY) {
                resource.setMark(lastCycle.getCapacity());
            }
        } else {
            resource.setMark(0);
        }

        return resource;
    }

    public void memory(Resource resource, boolean memory) {
        Date now = new Date();
        if (!memory) {
            resource.setFirstTime(now);
        }
        resource.setLastTime(now);
        resource.setMemory(String.valueOf(memory));
    }
}
