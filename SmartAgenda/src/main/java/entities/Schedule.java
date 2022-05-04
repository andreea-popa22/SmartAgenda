package entities;

import lombok.Data;

import java.util.Hashtable;
import java.util.List;

@Data
public class Schedule {
    private Hashtable<String, List<TimeSlot>> schedule;
}
