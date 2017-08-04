package agrifarm;

import java.util.Date;

/**
 * @author Dharshana
 * Sensor Class
 */
public class Sensor {
    private GPSCoord location;
    private Boolean enabled;
    private long frequency;
    private Date lastCheck;
    private int sensorId;
    private SensorType sensorType;
    private SensorReader sensorReader;
    private FieldStation fieldStation;
    
    public enum SensorType { 
        AIR_TEMPERATURE,
        PRESSURE,
        SOIL_MOISTURE,
        ACIDITY,
        SOIL_TEMPERATURE,
        LIGHT_SENSOR
    }
    
    //temp fieldStation
    public enum FieldStation{
        FS1
    }

    public Sensor(GPSCoord location, Boolean enabled, long frequency, Date lastCheck, int sensorId, SensorType sensorType, SensorReader sensorReader, FieldStation fieldStation) {
        this.location = location;
        this.enabled = enabled;
        this.frequency = frequency;
        this.lastCheck = lastCheck;
        this.sensorId = sensorId;
        this.sensorType = sensorType;
        this.sensorReader = sensorReader;
        this.fieldStation = fieldStation;
    }
    
}


