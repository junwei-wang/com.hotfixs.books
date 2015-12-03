package com.hotfixs.thinkinginjava.innerclasses.greenhouse;

import com.hotfixs.thinkinginjava.innerclasses.controllers.Controller;
import com.hotfixs.thinkinginjava.innerclasses.controllers.Event;

/**
 * @author wang
 */
public class GreenhouseControls extends Controller {

    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();
        gc.addEvent(gc.new Bell(900));

        Event[] events = {
                gc.new LightOn(200),
                gc.new LightOff(400),
                gc.new WaterOn(600),
                gc.new WaterOff(800)
        };
        Event restart = gc.new Restart(2000, events);
        gc.addEvent(restart);

        gc.addEvent(new Terminate(100000000));
        gc.run();
    }

    private boolean light = false;

    public class LightOn extends Event {

        public LightOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = true;
        }

        @Override
        public String toString() {
            return "Light is on";
        }
    }

    public class LightOff extends Event {

        public LightOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = false;
        }

        @Override
        public String toString() {
            return "Light is off";
        }
    }

    private boolean water = false;

    public class WaterOn extends Event {

        public WaterOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            water = true;
        }

        @Override
        public String toString() {
            return "Water is on";
        }
    }

    public class WaterOff extends Event {

        public WaterOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = false;
        }

        @Override
        public String toString() {
            return "Water is off";
        }
    }

    // insert a new one of itself into the event list
    public class Bell extends Event {
        public Bell(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            addEvent(new Bell(delayTime));
        }

        @Override
        public String toString() {
            return "Bing!!!";
        }
    }

    public class Restart extends Event {
        private Event[] events;

        public Restart(long delayTime, Event[] events) {
            super(delayTime);
            this.events = events;
        }

        @Override
        public void action() {
            for (Event e : events) {
                e.start();
                addEvent(e);
            }
        }

        @Override
        public String toString() {
            return "Restarting system";
        }
    }

    public static class Terminate extends Event {

        public Terminate(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            System.exit(0);
        }

        @Override
        public String toString() {
            return "Terminating";
        }
    }
}
