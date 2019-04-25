package com.water.water_station.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.xml.crypto.Data;

import com.water.water_station.beans.Datasource;
import com.water.water_station.beans.Gateway;
import com.water.water_station.beans.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(
        method={RequestMethod.POST,RequestMethod.GET} 
    )

public class PageController{
    public boolean wasLogged=true;
    @Autowired private EntityManager manager;

    public Gateway gateway;
    public Datasource datasource;
    public Users users;


    public List <Users> lUsers = new ArrayList<Users>();
    public List <Datasource> datasources = new ArrayList<Datasource>();

    public boolean config=false;
    private boolean wrong=false;
    private boolean verification = false;


    
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
        this.manager.getTransaction();
        model.addAttribute("users", users);
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
        if(gateway == null){
            gateway = new Gateway();
            datasource = new Datasource();
        }
        model.addAttribute("wrong", wrong);
        model.addAttribute("gateway", this.gateway);
        model.addAttribute("datasource", this.datasource);
        model.addAttribute("config", this.config);
        model.addAttribute("key",5);
        model.addAttribute("verification", this.verification);


        return "index";
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("key",6);
        model.addAttribute("users", users);
        model.addAttribute("users", lUsers);
        return "index";
    }

    @Transactional
    @PostMapping(
        value="/gateway",
        headers="Accept=application/x-www-form-urlencoded",
        consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.ALL_VALUE})
    public String gateway(Model model,
        @Valid Gateway gateway,
        @Valid @RequestParam(value = "uname") String uname,
        @Valid @RequestParam(value = "pword") String pword
        ){
        this.gateway = gateway;
        System.out.println(uname +" "+pword );
        if(uname.length() == 5){
            Query query = manager.createNativeQuery("SELECT count(g.id) FROM gateway_sd g");
            if(Integer.parseInt(query.getSingleResult().toString()) != 0){
                System.out.println("UPDATE gateway_sd SET db_name='"+gateway.getDb_name()+"',db_password='"+gateway.getDb_password()+"',db_user='"+gateway.getDb_user()+"',ip='"+gateway.getIp()+"',label='"+gateway.getLabel()+"',port='"+gateway.getPort()+"'");
                this.manager.createNativeQuery("UPDATE gateway_sd SET db_name='"+gateway.getDb_name()+"',db_password='"+gateway.getDb_password()+"',db_user='"+gateway.getDb_user()+"',ip='"+gateway.getIp()+"',label='"+gateway.getLabel()+"',port='"+gateway.getPort()+"'").executeUpdate();
                this.manager.flush();
            }else{
                this.manager.persist(gateway);
            }
            this.wrong = false;
            this.config = true;
        }else{
            this.wrong = true;
        }
        System.out.println(this.wrong);
        model.addAttribute("wrong", wrong);
        model.addAttribute("config", config);
        model.addAttribute("gateway", gateway);
        model.addAttribute("key",5);
        this.manager.clear();
        return "index";

    }


    @GetMapping("/edit")
    public String editGateway(Model model){
        this.config = false;
        model.addAttribute("config", config);
        model.addAttribute("gateway", gateway);
        model.addAttribute("key",5);

        return "index";
    }

    @Transactional
    @PostMapping(
        value="/datasource",
        headers="Accept=application/x-www-form-urlencoded",
        consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.ALL_VALUE})
    public String datasource(Model model,
                            @Valid Datasource ds){
        model.addAttribute("key",5);
        model.addAttribute("config", this.config);
        model.addAttribute("gateway", this.gateway);
        datasources.add(ds);
        model.addAttribute("datasources", this.datasources);


        //this.manager.persist(datasource);
        System.out.println(datasource.getId());
        return "index";
    }






















    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   Model model) {

        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a file to upload");
            return "index";
        }
        try {
            System.out.println(Base64Utils.encodeToString(file.getBytes()));
            this.verification = true;
            model.addAttribute("message","Successfully uploaded \n '" + file.getOriginalFilename() + "'");
            model.addAttribute("wrong", wrong);
            model.addAttribute("config", config);
            model.addAttribute("gateway", gateway);
            model.addAttribute("key",5);
            model.addAttribute("verification", this.verification);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(this.verification);
        
        return "index";
    }
}