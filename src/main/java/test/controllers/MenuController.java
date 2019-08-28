package test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import test.dao.mybatisplusservice.MenuServiceImpl;
import test.domain.interfaces.MenuService;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/menuController")
public class MenuController {

    @Autowired
    private MenuServiceImpl menuServiceImpl;

    @GetMapping("/getmenu1")
    @ResponseBody
    public List getmenu1(){
        System.out.println(menuServiceImpl.getmenu1());
        return menuServiceImpl.getmenu1();
    }
}