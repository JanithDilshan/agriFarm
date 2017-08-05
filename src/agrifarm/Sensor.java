package agrifarm;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Dharshana
 * Sensor Class
 */

public class Sensor implements Serializable{
//    private GPSCoord location;
    private String location;
    private boolean enabled;
    private long frequency;
    private Date lastCheck;
    private int sensorId;
    private SensorType sensorType;
    private SensorReader sensorReader;
    private FieldStation fieldStation;
    
    public enum SensorType{ 
        AIR_TEMPERATURE,
        PRESSURE,
        SOIL_MOISTURE,
        ACIDITY,
        SOIL_TEMPERATURE,
        LIGHT_SENSOR
    }
    
    //fixme: temp fieldStation
    public enum FieldStation{
        FS1
    }
    
    
    public String getLocation() {
        return location;
    }

    public long getFrequency() {
        return frequency;
    }

    public String getSensorType() {
        String sensorType = "";
         switch(this.sensorType){
            case AIR_TEMPERATURE:
                sensorType="Air Temperature";
                break;
            case PRESSURE:
                sensorType="Pressure";
                break;
            case SOIL_MOISTURE:
                sensorType="Soil Moisture";
                break;
            case ACIDITY:
                sensorType="Acidity";
                break;
            case SOIL_TEMPERATURE:
                sensorType="Soil Temperature";
                break;
            case LIGHT_SENSOR:
                sensorType="Light Sensor";
                break;
          }
         return sensorType;
    }

    public Sensor(String location, boolean enabled, long frequency, Date lastCheck, int sensorId, SensorType sensorType, SensorReader sensorReader, FieldStation fieldStation) {
        this.location = location;
        this.enabled = enabled;
        this.frequency = frequency;
        this.lastCheck = lastCheck;
        this.sensorId = sensorId;
        this.sensorType = sensorType;
        this.sensorReader = sensorReader;
        this.fieldStation = fieldStation;
    }
    
    public void updateSensorConfig(boolean enabled, long frequency){
        this.frequency=frequency;
        this.enabled=enabled;
    }
    
    public boolean requiresUpdate(){
        //fixme: implement this later
        //for now return true
        return true;
    }
    
    public void setReader(SensorReader sensorReader){
        this.sensorReader=sensorReader;
    }
    
    public boolean isEnabled(){
        return this.enabled;
    }
    
    public void readSensorDataIfRequired(){
        //fixme: implement this later
    }
}




