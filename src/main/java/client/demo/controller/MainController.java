package client.demo.controller;

import client.demo.dto.cavab.*;
import client.demo.dto.sorgu.SorguLogin;
import client.demo.dto.sorgu.SorguMusteri;
import client.demo.dto.sorgu.SorguToken;
import client.demo.service.HesabService;
import client.demo.service.LoginService;
import client.demo.service.MusteriService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class MainController {

    private final MusteriService musteriService;
    private final LoginService loginService;
    private final HesabService hesabService;


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping({"/", "/login-page"})
    public ModelAndView loginPage(@RequestParam(required = false) String message) {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("message", message);
        return modelAndView;

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public RedirectView login(SorguLogin sorguLogin, HttpServletRequest request) {
        RedirectView redirectView = null;
        try {
            Cavab<CavabUser> cavab = loginService.login(sorguLogin);
            if (cavab.getRespons_Status().getCode() == 1) {
                HttpSession session = request.getSession(true);
                session.setAttribute("user", cavab.getT().getCavabToken());
                redirectView = new RedirectView("/client/index");
            } else {

                redirectView = new RedirectView("/client/login-page");
                redirectView.addStaticAttribute("message", "username or password is invalid");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return redirectView;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/index")
    public ModelAndView getMusteriList(@RequestParam(required = false) String message, HttpServletRequest request) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession(false);
        CavabToken token = (CavabToken) session.getAttribute("user");
        SorguToken sorguToken = convertToken(token);
        Cavab<List<CavabMusteri>> musteriler = musteriService.getMusteriList(sorguToken);
        if (musteriler.getRespons_Status().getCode() == 1) {
            modelAndView.setViewName("index");
            modelAndView.addObject("musteriler", musteriler.getT());
            modelAndView.addObject("message", message);
        } else {
            modelAndView.setViewName("customerEmpty");
        }
        return modelAndView;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/hesab")
    public ModelAndView viewAccount(@RequestParam Long musteriId) throws Exception {
        ModelAndView model = new ModelAndView("accounts");
        Cavab<List<CavabHesab>> hesablar = hesabService.getHesabList(musteriId);
        if (hesablar.getRespons_Status().getCode() == 1) {
            model.setViewName("accounts");
            model.addObject("accounts", hesablar.getT());
        } else {
            model.setViewName("xeta");
            model.addObject("xeta", "xeta");
        }
        return model;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("musteri/add")
    public ModelAndView addMusteri(@RequestParam(required = false) String message) {
        ModelAndView model = new ModelAndView("createCustomer");
        model.addObject("message", message);
        return model;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping(value = "/musteri/create", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public RedirectView createMusteri(SorguMusteri sorguMusteri, HttpServletRequest request) {
        RedirectView redirectView = null;
        try {
            HttpSession session = request.getSession(false);
            CavabToken token = (CavabToken) session.getAttribute("user");
            SorguToken sorguToken = convertToken(token);
            sorguMusteri.setSorguToken(sorguToken);
            Cavab cavab = musteriService.addMusteri(sorguMusteri);
            if (cavab.getRespons_Status().getCode() == 1) {
                redirectView = new RedirectView("/client/index");
            } else {
                redirectView = new RedirectView("client/musteri/add");
                redirectView.addStaticAttribute("message", "Customer adding process failed");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return redirectView;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private SorguToken convertToken(CavabToken cavabToken) {

        return SorguToken.builder()
                .userId(cavabToken.getUserId())
                .token(cavabToken.getToken())
                .build();
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
