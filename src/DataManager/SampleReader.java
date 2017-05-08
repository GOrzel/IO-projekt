package DataManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


class SampleReader {

    private ArrayList<Probka> allSamplesList = new ArrayList<>();


    ArrayList<Probka> readSample() {
        try {
            String stringSample;
            BufferedReader br = new BufferedReader(new FileReader("samplesOfficial.csv"));
            while ((stringSample = br.readLine()) != null) {
                stringSample = stringSample.substring(0, stringSample.length()-1);
                String[] sample = stringSample.split(",");
                Probka currentSample= new Probka();

                currentSample.data = Float.valueOf(sample[0]+"000");                                                    //dodaję 3 zera do postaci zwyklego timestampa
                currentSample.numerPomiaru = Float.valueOf(sample[1]);
                currentSample.patient = sample[2];
                currentSample.measure = (sample[3]);
                switch (currentSample.measure) {
                    case "Temp":
                        currentSample.Temp = Float.valueOf(sample[4]);
                        break;
                    case "HRate":
                        currentSample.HRate = Float.valueOf(sample[4]);
                        break;
                    case "BPressure":
                        currentSample.BPressure = (sample[4]);
                        break;
                    case "Sugar":
                        currentSample.Sugar = Float.valueOf(sample[4]);
                        break;
                    case "BMI":
                        currentSample.BMI = Float.valueOf(sample[4]);
                        break;
                }
                    currentSample.type = (sample[5]);

                    allSamplesList.add(currentSample);
                //    System.out.println("name: " + currentSample.patient + ", typ pomiaru: " + currentSample.type + ", pomiar: " + currentSample.measure);
            }
            } catch(IOException e){
                e.printStackTrace();
            }
        return allSamplesList;
    }
}
