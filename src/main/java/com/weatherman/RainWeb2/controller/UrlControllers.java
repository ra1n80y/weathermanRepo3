package com.weatherman.RainWeb2.controller;

import com.weatherman.RainWeb2.model.FormPOJO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//Focus:Receiving data from URL & Bi-directional mapping

@Controller
public class UrlControllers
{
    public UrlControllers()
    {
        System.out.println ("@RequestParam URL :http://localhost:8080/RainWebApp2/getmsg?name=insertName");
        System.out.println ("@PathVariable URL :http://localhost:8080/RainWebApp2/getmsg/param1/param2");
        System.out.println ("Bi-directional URL :http://localhost:8080/RainWebApp2/register");
    }

    //Data is passed via a query that selects a manually initialized key-value pair (?key=value)
    @GetMapping("getmsg")
    public String dispMsg1(@RequestParam("name") String n, Map<String,Object>model)
    {
        //@RequestParam is used when var. name and param string/key's name don't match
        //"&" cn be used to add another key-value pair(Req. another @RequestParam anno)
        String message ="Yo "+n+"!";
        model.put ("message", message);

        return "index";
    }

    //Data is passed directly in URL path
    @GetMapping("getmsg/{name}/{surname}")
    public String dispMsg2(@PathVariable("name")String name, @PathVariable("surname") String surname, Map<String,Object>model)
    {
        //@PathVariable strings should always match curly brackets
        String message2 ="Sup! "+name+" "+surname;
        model.put ("msg2", message2);

        return "SecondView";
    }

    //Bi-directional mapping
    @GetMapping("register")
    public String homePage(Map<String, Object>model)
    {
        String ss="Sign Up here!";
        model.put ("getForm",ss);

        return "form";
    }

    @PostMapping("register")
    public String dispMsg4(Map<String, Object>model,@ModelAttribute("form") FormPOJO PJ)
    {
        System.out.println (PJ);
        model.put ("form",PJ);

        return "result";
    }




}
