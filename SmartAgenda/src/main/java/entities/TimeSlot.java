package entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;

@Getter
@Setter
public class TimeSlot {
    private Hour start;
    private Hour end;
}
