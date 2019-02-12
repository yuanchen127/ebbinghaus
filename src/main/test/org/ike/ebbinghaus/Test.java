package org.ike.ebbinghaus;


import org.ike.ebbinghaus.entity.Resource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    private static ArrayList<Cycle> cycleList = new ArrayList<Cycle>();
    public static void main(String[] args) throws ParseException {


        cycleList.add(new Cycle(Calendar.MINUTE, -20, 58.20));
        cycleList.add(new Cycle(Calendar.HOUR, -1, 44.20));
        cycleList.add(new Cycle(Calendar.HOUR, -8, 35.80));
        cycleList.add(new Cycle(Calendar.DAY_OF_YEAR, -1, 33.70));
        cycleList.add(new Cycle(Calendar.DAY_OF_YEAR, -2, 27.80));
        cycleList.add(new Cycle(Calendar.DAY_OF_YEAR, -6, 25.40));
        cycleList.add(new Cycle(Calendar.MONTH, -1, 21.10));

        String firstTime = "2019-01-20 00:00:00";
        String lastTime = "2019-02-06 23:58:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        Resource resource = new Resource();
        resource.setFirstTime(sdf.parse(firstTime));
        resource.setLastTime(sdf.parse(lastTime));

        mark(resource);
    }

    public static void mark(Resource resource) {
        long firstTime = resource.getFirstTime().getTime();
        Calendar lastTime = Calendar.getInstance();
        lastTime.setTime(resource.getLastTime());

        Calendar now = Calendar.getInstance();
        Collections.sort(cycleList, new Comparator<Cycle>() {
            @Override
            public int compare(Cycle c1, Cycle c2) {
                Calendar var1 = Calendar.getInstance();
                var1.setTime(resource.getLastTime());
                var1.add(c1.getUnit(), c1.getIncrement());

                Calendar var2 = Calendar.getInstance();
                var2.setTime(resource.getLastTime());
                var2.add(c2.getUnit(), c2.getIncrement());

                System.out.println("c1-"+c1.getCapacity()+" c2-"+c2.getCapacity()+" "+(firstTime - var1.getTimeInMillis())+" "+(firstTime - var2.getTimeInMillis()));
                return Math.abs(firstTime - var1.getTimeInMillis()) >= Math.abs(firstTime - var2.getTimeInMillis()) ? 0 : -1;
            }
        });

        System.out.println(cycleList.get(0).getCapacity());

    }
}
