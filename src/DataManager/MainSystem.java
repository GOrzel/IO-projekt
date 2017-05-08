package DataManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Grzegorz on 2017-05-07.
 */
public class MainSystem {

    public static void main(String[] args) {
        Map<String, PatientAlarmLevels> alarmLevels = new HashMap<>();
        ArrayList<Probka> samples;
        SampleReader reader = new SampleReader();
        AlarmReportControl controller = new AlarmReportControl();
        samples = reader.readSample();                                                                                  //wczytanie próbek

        //System.out.println(samples.size());
        int lastReportMonth=-1;
        for(Probka a : samples){
            alarmLevels.putIfAbsent( a.patient, new PatientAlarmLevels());//jeśli nie ma odpowiedniego wpisu poziomów alarmów to go stwórz(wartosci domyslne)
            //System.out.println(a.numerPomiaru);

        }
        //System.out.println(alarmLevels.size());
        SampleChecker checker = new SampleChecker();
        for(Probka a : samples) {
            checker.check(a,alarmLevels.get(a.patient));
            controller.checkReport(lastReportMonth,a.data);
        }
    }
}
