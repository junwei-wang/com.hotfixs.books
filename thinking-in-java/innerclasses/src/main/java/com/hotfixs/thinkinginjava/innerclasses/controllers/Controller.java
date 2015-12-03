package com.hotfixs.thinkinginjava.innerclasses.controllers;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wang
 */
public class Controller {
    private List<Event> eventList = new ArrayList<>();

    public void addEvent(Event e) {
        eventList.add(e);
    }

    public void run() {
        while (eventList.size() > 0) {
            // make a copy of eventList, because we are modify it.
            new ArrayList<>(eventList).stream()
                    .filter(event -> event.ready())
                    .forEach(event -> {
                        print(event);
                        event.action();
                        eventList.remove(event);
                    });
        }
    }
}
