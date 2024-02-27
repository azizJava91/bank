package client.demo.dto.sorgu;

import lombok.Data;

import java.util.Date;

@Data
public class SorguMusteri {
    private Long musteriId;
    private String name;
    private String surname;
    private String address;
    private String dob;
    private String phone;
    private String pin;
    private String seria;
    private String cif;
    private String gender;
    private SorguToken sorguToken;

}
