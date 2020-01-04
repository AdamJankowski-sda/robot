import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Robot {

    private Map<RuchRobota,Double> BatteryUsageMapping;
    private Double BatteryLevel;
    private Boolean powerOn;

    public Robot(){
        BatteryUsageMapping = new HashMap<>();
        BatteryLevel = 100.0;
        BatteryUsageMapping.put(RuchRobota.KROK_LEWA,50.0);
        BatteryUsageMapping.put(RuchRobota.KROK_PRAWA,10.0);
        BatteryUsageMapping.put(RuchRobota.RUCH_REKA_LEWA,5.0);
        BatteryUsageMapping.put(RuchRobota.RUCH_REKA_PRAWA,5.0);
        BatteryUsageMapping.put(RuchRobota.SKOK,15.0);
        powerOn = false;
    }



}
