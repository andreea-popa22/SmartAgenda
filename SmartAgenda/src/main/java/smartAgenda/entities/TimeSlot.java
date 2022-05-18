package smartAgenda.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimeSlot {
    private Hour start;
    private Hour end;
}
