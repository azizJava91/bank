package client.demo.service;



import client.demo.dto.cavab.Cavab;
import client.demo.dto.cavab.CavabMusteri;
import client.demo.dto.sorgu.SorguMusteri;
import client.demo.dto.sorgu.SorguToken;

import java.util.List;

public interface MusteriService {


    Cavab<CavabMusteri> getMusteriById(Long musteriId) throws Exception;

    Cavab<List<CavabMusteri>> getMusteriList(SorguToken sorguToken) throws Exception;

    Cavab addMusteri(SorguMusteri sorguMusteri) throws Exception;



}
