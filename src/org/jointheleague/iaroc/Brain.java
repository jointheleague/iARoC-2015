package org.jointheleague.iaroc;

import android.os.SystemClock;

import ioio.lib.api.DigitalOutput;
import ioio.lib.api.IOIO;
import ioio.lib.api.exception.ConnectionLostException;
import org.wintrisstech.irobot.ioio.IRobotCreateAdapter;
import org.wintrisstech.irobot.ioio.IRobotCreateInterface;
import org.jointheleague.iaroc.sensors.UltraSonicSensors;

public class Brain extends IRobotCreateAdapter {
    private final Dashboard dashboard;
    public UltraSonicSensors sonar;
    public IOIO ioio;
    public DigitalOutput led;

    public Brain(IOIO ioio, IRobotCreateInterface create, Dashboard dashboard)
            throws ConnectionLostException {
        super(create);
        sonar = new UltraSonicSensors(ioio);
        this.dashboard = dashboard;
        this.ioio = ioio;
    }

    /* This method is executed when the robot first starts up. */
    public void initialize() throws ConnectionLostException {
        dashboard.log("Hello! I'm a Clever Robot!");
        led = ioio.openDigitalOutput(IOIO.LED_PIN);
    }
    /* This method is called repeatedly. */
    public void loop() throws ConnectionLostException {
        SystemClock.sleep(100);
        led.write(false);
        SystemClock.sleep(100);
        led.write(true);
//        try
//        {
//            sonar.read();
//            dashboard.log(sonar.getLeftDistance() + "        " + sonar.getFrontDistance() + "                " + sonar.getRightDistance());
//        } catch (InterruptedException e)
//        {
//            dashboard.log("sonar hiccup");
//        }
    }
}