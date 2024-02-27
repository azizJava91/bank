package client.demo.dto.cavab;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CavabStatus {
    private Integer code;
    private String message;
    private static final Integer SUCCESS_CODE = 1;
    private static final String SUCCESS_MESSAGE = "success";

    public static CavabStatus getSuccessMessage() {

        return new CavabStatus(SUCCESS_CODE, SUCCESS_MESSAGE);

    }
}
