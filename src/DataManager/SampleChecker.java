package DataManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.lang.Math;

import static java.lang.Math.abs;

/**
 * Created by User on 2017-05-07.
 */
public class SampleChecker {



    public boolean check(Probka sample, PatientAlarmLevels patient){
        if(sample.type.equals("M")) {
            switch (sample.measure) {
                case "Temp":
                    if (sample.Temp < patient.downTemp || sample.Temp > patient.upTemp){
                        System.out.println("Parameter " + sample.measure + " is outside acceptable range.");
                    }
                        break;
                case "HRate":
                    if (sample.HRate < patient.downHRate || sample.HRate > patient.upHRate){
                        System.out.println("Parameter " + sample.measure + " is outside acceptable range.");
                    }
                    break;
                case "BPressure":
                    /*String[] sampleBPressure = sample.BPressure.split("/");
                    String[] upBPressure = patient.upBPressure.split("/");
                    String[] downBPressure = patient.downBPressure.split("/");
                    if (sampleBPressure[0] < downBPressure[0] || sampleBPressure[0] > upBPressure[0]){
                        System.out.println("Parameter " + sample.measure + " is outside acceptable range.");
                    }*/
                    break;
                case "Sugar":
                    if (sample.Sugar < patient.downSugar || sample.Sugar > patient.upSugar){
                        System.out.println("Parameter " + sample.measure + " is outside acceptable range.");
                    }
                    break;
                case "BMI":
                    if (sample.BMI < patient.downBMI || sample.BMI > patient.upBMI){
                        System.out.println("Parameter " + sample.measure + " is outside acceptable range.");
                    }
                    break;
            }
        }else{
            switch (sample.measure) {
                case "Temp":
                    if (abs(sample.Temp - patient.upTemp) <= abs(sample.Temp - patient.downTemp)){
                        patient.upTemp=sample.Temp;
                        System.out.println("Up value for " + sample.measure + " for " + sample.patient + " changed to " + sample.Temp);
                    }else{patient.downTemp = sample.Temp;}
                    break;
                case "HRate":
                    if (abs(sample.HRate - patient.upHRate) <= abs(sample.HRate - patient.downHRate)){
                        patient.upHRate=sample.HRate;
                        System.out.println("Up value for " + sample.measure + " for " + sample.patient + " changed to " + sample.HRate);
                    }else{patient.downHRate = sample.HRate;}
                    break;
                case "BPressure":
                    Float sampleBPressure = Float.valueOf((sample.BPressure.split("/"))[0]);
                    Float upBPressure = Float.valueOf((patient.upBPressure.split("/"))[0]);
                    Float downBPressure = Float.valueOf((patient.downBPressure.split("/"))[0]);
                    if (abs(sampleBPressure - upBPressure) <= abs(sampleBPressure - downBPressure)){
                        patient.upBPressure = Float.toString(upBPressure);
                        System.out.println("Up value for " + sample.measure + " for " + sample.patient + "changed to " + sample.BPressure);
                    }else{patient.downBPressure = Float.toString(downBPressure);}
                    break;
                case "Sugar":
                    if (abs(sample.Sugar - patient.upSugar) <= abs(sample.Sugar - patient.downSugar )){
                        patient.upSugar = sample.Sugar;
                        System.out.println("Up value for " + sample.measure + " for " + sample.patient + " changed to " + sample.Sugar );
                    }else{patient.downSugar = sample.Sugar;}
                    break;
                case "BMI":
                    if (abs(sample.BMI - patient.upBMI ) <= abs(sample.BMI - patient.downBMI )){
                        patient.upBMI =sample.BMI ;
                        System.out.println("Up value for " + sample.measure + " for " + sample.patient + " changed to " + sample.BMI );
                    }else{patient.downBMI = sample.BMI;}
                    break;
            }
        }
        return false;
    }
}
