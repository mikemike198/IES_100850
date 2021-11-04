package pt.ua.spring_web_app.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import pt.ua.spring_web_app.Models.NameForm;
import pt.ua.spring_web_app.Models.Greeting;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/home")
    public ModelAndView home(Model model) {
        model.addAttribute("name_form", new NameForm());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value="/home", method=RequestMethod.POST, params="action=Submit")
    public ModelAndView home_submit(@ModelAttribute NameForm name_form, Model model) {
        return new ModelAndView("redirect:/greeting?name="+name_form.getName());
    }

    @RequestMapping(value="/home", method=RequestMethod.POST, params="action=Api")
    public ModelAndView home_api(@ModelAttribute NameForm name_form, Model model) {
        return new ModelAndView("redirect:/greetingAPI?name="+name_form.getName());
    }
    
    @GetMapping("/greeting") // The string inside is the path to the specific view
    public ModelAndView greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model)
    {
        model.addAttribute("name", name);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("greeting");
        return modelAndView;
    }

    @GetMapping("/greetingAPI")
    public Greeting greetingAPI(@RequestParam(value="name", defaultValue = "World") String name) 
    {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
