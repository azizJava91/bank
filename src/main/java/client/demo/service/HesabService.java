package client.demo.service;
import client.demo.dto.cavab.Cavab;
import client.demo.dto.cavab.CavabHesab;
import client.demo.dto.sorgu.SorguHesab;

import java.util.List;

public interface HesabService {
    Cavab<List<CavabHesab>> getHesabList(Long musteriId) throws Exception;
    Cavab createHesab(SorguHesab sorguHesab) throws Exception;
}
