package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InterfaceController {
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/lojas")
    public String lojas(Model model) {
//        model.addAllAttributes( /*TODO metodo que pega as lojas*/ );
        return "lojas";
    }

}
