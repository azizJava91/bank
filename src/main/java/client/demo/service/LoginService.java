package client.demo.service;


import client.demo.dto.cavab.Cavab;
import client.demo.dto.cavab.CavabUser;
import client.demo.dto.sorgu.SorguLogin;

public interface LoginService {
    Cavab<CavabUser> login(SorguLogin sorguLogin) throws Exception;

}
