package client.demo.dto.cavab;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cavab<T> {
    @JsonProperty(value = "respons")
    private T t;

    private CavabStatus respons_Status;

}



