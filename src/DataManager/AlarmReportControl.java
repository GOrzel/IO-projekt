package DataManager;

import java.util.Calendar;

/**
 * Created by User on 2017-05-07.
 */
public class AlarmReportControl {

    void checkReport(int lastMonth, float currentTime) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis((long) currentTime);
        //System.out.println(cal.get(Calendar.MONTH));
        if(lastMonth != cal.get(Calendar.MONTH)) {/*generuj raport*/}
    }
}
