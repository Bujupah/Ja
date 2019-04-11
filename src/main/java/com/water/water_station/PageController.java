
package com.water.water_station;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class PageController {

	public static void main(String[] args) {
		SpringApplication.run(PageController.class, args);
    }
    

    @GetMapping("/")
    public String root() {
        return "index";
    }


    // ###                                  ###
    // ###                                  ###
    // ###               AUTH               ###
    // ###                                  ###
    // ###                                  ###
    @GetMapping("/login")
    public String login() {

        return "/auth/login";
    }


    // ###                                  ###
    // ###                                  ###
    // ###              PROFILES            ###
    // ###                                  ###
    // ###                                  ###
    @GetMapping("/profile/user/user")
    public String user() {
        return "/profile";
    }

    @GetMapping("/profile/admin/admin")
    public String admin() {
        return "/profile";
    }

    // ###                                  ###
    // ###                                  ###
    // ###               ERROR              ###
    // ###                                  ###
    // ###                                  ###
    @GetMapping("/error/403")
    public String error403() {
        return "/nope";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }

    // ###                                  ###
    // ###                                  ###
    // ###              DASHBOARD           ###
    // ###                                  ###
    // ###                                  ###
    @GetMapping("/dashboard/main")
    public String main() {
        return "/dashboard/main";
    }

    @GetMapping("/dashboard/maintenance")
    public String maintenance() {
        return "/dashboard/maintenance";
    }

    @GetMapping("/dashboard/history")
    public String history() {
        return "/dashboard/history";
    }
    
    @GetMapping("/dashboard/reports")
    public String reports() {
        return "/dashboard/reports";
    }

    @GetMapping("/profile/admin/settings")
    public String settings() {
        return "/dashboard/settings";
    }
}
