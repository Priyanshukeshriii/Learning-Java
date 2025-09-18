package com.miniproject.collegeData;

import java.util.ArrayList;

public class SchduleData {
    public static ArrayList<Schedule> scheduleList = new ArrayList<>();
    static {
        scheduleList.add(new Schedule("CS101", "Data Structures", "Monday", "10:00 AM - 11:30 AM", "Room 101", "Dr. Sharma"));
        scheduleList.add(new Schedule("CS102", "Database Systems", "Tuesday", "12:00 PM - 1:30 PM", "Room 202", "Prof. Meena"));
        scheduleList.add(new Schedule("CS103", "Operating Systems", "Wednesday", "9:00 AM - 10:30 AM", "Room 303", "Dr. Gupta"));
        scheduleList.add(new Schedule("CS104", "Computer Networks", "Friday", "2:00 PM - 3:30 PM", "Room 404", "Dr. Ramesh"));

    }
}
