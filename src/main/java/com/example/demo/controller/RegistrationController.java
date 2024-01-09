package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.services.RegService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class RegistrationController {
    private RegService regService;

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration-form";
    }

    @PostMapping("/registration")
    public String processRegistrationForm(@ModelAttribute User user) {
        // Обработка данных из формы
        System.out.println("Name: " + user.getName());
        System.out.println("Phone Number: " + user.getPhoneNumber());
        System.out.println("Date and Time: " + user.getDateTime());
        regService.addUser(user);

        // Ваша логика обработки данных

        return "redirect:/success";  // перенаправление на страницу успешного завершения
    }
}
