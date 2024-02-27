package client.demo.service;

import client.demo.dto.cavab.Cavab;
import client.demo.dto.cavab.CavabHesab;
import client.demo.dto.sorgu.SorguHesab;
import client.demo.utility.ApiUrl;
import client.demo.utility.Utility;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class HesabServiceImpl implements HesabService {

    private final Utility utility;

    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public Cavab<List<CavabHesab>> getHesabList(Long musteriId) throws Exception {
        String result = utility.sendGet(ApiUrl.URL.value+"hesab/list?musteriId="+musteriId);
        Cavab<List<CavabHesab>> hesablar = objectMapper.readValue(result, new TypeReference<>() {});
        return hesablar ;
    }

    @Override
    public Cavab createHesab(SorguHesab sorguHesab) throws Exception {
        return null;
    }
}
