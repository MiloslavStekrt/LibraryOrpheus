package dev.levia.LibraryOrpheus.dio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.levia.LibraryOrpheus.own.OperationMethods;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping
public class MainController {

  @GetMapping(path = "/greet")
  public String hi(Model m) {
    m.addAttribute("name", "Chack Noris");
    // m.addAttribute("navlinks", OperationMethods.navigation(1));
    return "hi";
  }

  @GetMapping
  public String homePage(Model m) {
    m.addAttribute("navlinks", OperationMethods.navigation(1));
    return "home_page";
  }

}
