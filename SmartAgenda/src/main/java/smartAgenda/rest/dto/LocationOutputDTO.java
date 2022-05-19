package smartAgenda.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LocationOutputDTO {
    @JsonProperty
    private String name;
}
