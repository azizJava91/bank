package client.demo.dto.cavab;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CavabUser {
private String username;
private String fullName;
private CavabToken cavabToken;

}
