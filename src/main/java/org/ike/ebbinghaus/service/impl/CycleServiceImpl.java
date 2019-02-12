package org.ike.ebbinghaus.service.impl;

import org.ike.ebbinghaus.dao.CycleDao;
import org.ike.ebbinghaus.entity.Cycle;
import org.ike.ebbinghaus.service.CycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@Service(value="cycleService")
public class CycleServiceImpl implements CycleService {

    @Autowired
    private CycleDao cycleDao;

    @Override
    @Transactional
    public int init() {
        ArrayList<Cycle> cycleList = new ArrayList<Cycle>();
        Cycle var1 = new Cycle(1, "ike", new Date(), "ike", new Date(), Calendar.MINUTE, -20, 58.20);
        Cycle var2 = new Cycle(2, "ike", new Date(), "ike", new Date(), Calendar.HOUR, -1, 44.20);
        Cycle var3 = new Cycle(3, "ike", new Date(), "ike", new Date(), Calendar.HOUR, -8, 35.80);
        Cycle var4 = new Cycle(4, "ike", new Date(), "ike", new Date(), Calendar.DAY_OF_YEAR, -1, 33.70);
        Cycle var5 = new Cycle(5, "ike", new Date(), "ike", new Date(), Calendar.DAY_OF_YEAR, -2, 27.80);
        Cycle var6 = new Cycle(6, "ike", new Date(), "ike", new Date(), Calendar.DAY_OF_YEAR, -6, 25.40);
        Cycle var7 = new Cycle(7, "ike", new Date(), "ike", new Date(), Calendar.MONTH, -1, 21.10);
        cycleList.add(var1);
        cycleList.add(var2);
        cycleList.add(var3);
        cycleList.add(var4);
        cycleList.add(var5);
        cycleList.add(var6);
        cycleList.add(var7);

        int sum = 0;
        try {

            for (Cycle cycle : cycleList) {
                int count = cycleDao.insert(cycle);
                sum += count;
            }
            return sum;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
