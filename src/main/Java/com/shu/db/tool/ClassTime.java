package com.shu.db.tool;

import java.util.ArrayList;

/**
 * Created by PoleToWin on 2019/4/22 21:40
 */
public class ClassTime {
    private ArrayList<DayTime> period;

    public ClassTime() {
    }

    public ClassTime(ArrayList<DayTime> period) {
        this.period = period;
    }

    public ArrayList<DayTime> getPeriod() {
        return period;
    }

    public void setPeriod(ArrayList<DayTime> period) {
        this.period = period;
    }

    @Override
    public String toString() {
        String s = "";
        for(DayTime dayTime :period){
            s+=dayTime.getDay() +","+dayTime.getStart()+","+dayTime.getEnd()+"\n";
            System.out.println("ClassTime s:"+s);
        }
        return s;
    }

}
