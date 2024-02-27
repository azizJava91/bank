package client.demo.dto.cavab;

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

public class CavabHesab {
    private Long hesabId;
    private CavabMusteri cavabMusteri;
    private String hesabNo;
    private String iban;
    private Double balance;
    private String valyuta;
    private Date data_date;


}

