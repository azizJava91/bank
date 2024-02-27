package client.demo.dto.cavab;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CavabMusteri {


    private Long musteriId;
    private String name;
    private String surname;
    private String address;
    private String phone;
    private String gender;
    private Date dob;
    private String cif;
    private String pin;
    private String seria;
}
