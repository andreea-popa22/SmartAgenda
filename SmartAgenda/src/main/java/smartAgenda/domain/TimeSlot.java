package smartagenda.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimeSlot {
    private Hour start;
    private Hour end;
}
