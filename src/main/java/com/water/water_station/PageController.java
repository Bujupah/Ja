package com.water.water_station;

import com.water.water_station.beans.Gateway;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController{
    public boolean wasLogged=true;
	public Gateway gateway;
    // ###                                  ###
    // ###                                  ###
    // ###               AUTH               ###
    // ###                                  ###
    // ###                                  ###
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("hasLogged",!wasLogged);
        wasLogged=true;
        return "/auth/login";
    }
    // ###                                  ###
    // ###                                  ###
    // ###             PROFILES             ###
    // ###                                  ###
    // ###                                  ###
    @GetMapping("/user")
    public String user(Model model) {
        model.addAttribute("key",7);
        return "/profile/user/user";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("key",8);
        return "/profile/admin/admin";
    }

    // ###                                  ###
    // ###                                  ###
    // ###               ERROR              ###
    // ###                                  ###
    // ###                                  ###
    @GetMapping("/error/403")
    public String error403() {
        return "/notfound";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }

    // ###                                  ###
    // ###                                  ###
    // ###             DASHBOARD            ###
    // ###                                  ###
    // ###                                  ###
    @GetMapping("/")
    public String root(Model model) {
        if(wasLogged){
            model.addAttribute("hasLogged",true);
            wasLogged=false;
        }else{
            model.addAttribute("hasLogged",false);
        }
        model.addAttribute("key",1);
        return "index";
    }

    @GetMapping("/maintenance")
    public String maintenance(Model model) {
        model.addAttribute("key",2);
        return "index";
    }

    @GetMapping("/history")
    public String history(Model model) {
        model.addAttribute("key",3);
        return "index";
    }
    
    @GetMapping("/reports")
    public String reports(Model model) {
        model.addAttribute("key",4);
        return "index";
    }

    @GetMapping("/settings")
    public String settings(Model model) {
        model.addAttribute("key",5);
        return "index";
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("key",6);
        return "index";
    }

    @GetMapping("/gateway")
    public String gateway(Model model,
                            @RequestParam String dbname,
                            @RequestParam String dbuser,
                            @RequestParam String dbpwd,
                            @RequestParam String entreprise,
                            @RequestParam String station,
                            @RequestParam String license,
                            @RequestParam String uname,
                            @RequestParam String pword) {
        if(gateway == null){
            gateway = new Gateway();
        }
        gateway.setDbname(dbname);
        gateway.setDbuser(dbuser);
        gateway.setDbpwd(dbpwd);
        gateway.setEntreprise(entreprise);
        gateway.setStation(station);
        gateway.setLicense(license);
        gateway.setUname(uname);
        gateway.setPword(pword);

        model.addAttribute("key",5);
        model.addAttribute("dbname",dbname);
        model.addAttribute("dbuser",dbuser);
        model.addAttribute("dbpwd",dbpwd);
        model.addAttribute("entreprise",entreprise);
        model.addAttribute("station",station);
        model.addAttribute("license",license);
        model.addAttribute("uname",uname);
        model.addAttribute("pword",pword);
        
        model.addAttribute("gateway", gateway);
        System.out.println(model);
        return "index";
    }
}