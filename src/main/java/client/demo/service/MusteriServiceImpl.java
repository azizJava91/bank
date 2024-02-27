package client.demo.service;


import client.demo.dto.cavab.Cavab;
import client.demo.dto.cavab.CavabMusteri;
import client.demo.dto.sorgu.SorguMusteri;
import client.demo.dto.sorgu.SorguToken;
import client.demo.utility.ApiUrl;
import client.demo.utility.Utility;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service


public class MusteriServiceImpl implements MusteriService {

    private final Utility utility;



    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Cavab<CavabMusteri> getMusteriById(Long musteriId) throws Exception {
        String result = utility.sendGet(ApiUrl.URL.value+"musteri/getById/" + musteriId);
        Cavab<CavabMusteri> cavab = objectMapper.readValue(result, new TypeReference<>() {
        });
        return cavab;
    }

    @Override
    public Cavab<List<CavabMusteri>> getMusteriList(SorguToken sorguToken) throws Exception {
        String sorguTokenJson = objectMapper.writeValueAsString(sorguToken);
        String result = utility.sendPost( ApiUrl.URL.value +"musteri/list", sorguTokenJson);
        Cavab<List<CavabMusteri>> cavab = objectMapper.readValue(result, new TypeReference<>() {
        });
        return cavab;
    }

    @Override
    public Cavab addMusteri(SorguMusteri sorguMusteri) throws Exception {
        String sorguMusteriJson = objectMapper.writeValueAsString(sorguMusteri);
        String result = utility.sendPost( ApiUrl.URL.value +"musteri/create", sorguMusteriJson);
        Cavab cavab = objectMapper.readValue(result, new TypeReference<>() {
        });
        return cavab;
    }




}

