package smartagenda.domain.embeddable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class ScheduleId implements Serializable {
    private int id;
    private int personPK;
}
