/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agrifarm;

import java.io.Serializable;

/**
 *
 * @author Dharshana
 */

//every sensor data returns 2 for now, fix later.
abstract public class SensorReader implements Serializable{
 abstract public double readSensorData();   
}
