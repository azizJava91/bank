package client.demo.service;


import client.demo.dto.cavab.Cavab;
import client.demo.dto.cavab.CavabUser;
import client.demo.dto.sorgu.SorguLogin;
import client.demo.utility.ApiUrl;
import client.demo.utility.Utility;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service


public class LoginServiceImpl implements LoginService {

    private final Utility utility;

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Cavab<CavabUser> login(SorguLogin sorguLogin) throws Exception {
        String sorguLoginJson = objectMapper.writeValueAsString(sorguLogin);
        String result = utility.sendPost(ApiUrl.URL.value+ "user/login", sorguLoginJson);
        Cavab<CavabUser> cavab = objectMapper.readValue(result, new TypeReference<>() {
        });
        return cavab;
    }
}
