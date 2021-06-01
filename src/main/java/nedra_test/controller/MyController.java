package nedra_test.controller;

import nedra_test.entity.Click;
import nedra_test.service.ClickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MyController {

    @Autowired
    private ClickService clickService;

    @RequestMapping("/")
    public String showFirstPage(Model model) {

        Click click = clickService.getClick();
        model.addAttribute("click", click);

        return "sum_of_clicks";
    }

    @RequestMapping("/count")
    public String showSumOfClicks(Model model) {

        Click click = clickService.getClickPlusOne();
        model.addAttribute("click", click);

        return "sum_of_clicks";
    }
}
