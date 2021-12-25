/*
This class is used to display all the events in the EventLog class. It has a method called printLog that takes an
EventLog object as a parameter and this method displays the events in the log one at a time.
 */

package ui.gui;

import model.Event;
import model.EventLog;

public class PrintLog {

    // REQUIRES: the EventLog object
    // MODIFIES: nothing
    // EFFECTS: displays all the events in the event log one at a time on the console.
    public void printLog(EventLog eventLog) {
        for (Event next : eventLog) {
            System.out.println(next.toString());
        }
    }
}
