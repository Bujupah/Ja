package com.water.water_station.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import com.water.water_station.beans.Gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(
        method={RequestMethod.POST,RequestMethod.GET} 
    )

public class PageController{
    public boolean wasLogged=true;
    @Autowired private EntityManager manager;

    public Gateway gateway;
    public boolean config=false;

    
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
        if(gateway == null){
            gateway = new Gateway();
        }
        model.addAttribute("gateway",gateway);
        model.addAttribute("config", config);
        model.addAttribute("key",5);

        return "index";
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("key",6);
        return "index";
    }

    @Transactional
    @PostMapping(
        value="/gateway",
        headers="Accept=application/x-www-form-urlencoded",
        consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.ALL_VALUE})
    public String gateway(Model model,
        @Valid Gateway gateway
        //@RequestParam(value = "uname") String uname,
        //@RequestParam(value = "pword") String pword ){
        ){
        config=!config;
        model.addAttribute("gateway", gateway);
        this.manager.persist(gateway);
        return "index";

    }














    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {
            //Files.write(path, bytes);
            System.out.println(Base64Utils.encodeToString(file.getBytes()));
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

}