package client.demo.dto.sorgu;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SorguHesab {
    private Long hesabId;
    private String hesabNo;
    private String iban;
    private Double balance;
    private String valyuta;
    private Long musteriId;
}
