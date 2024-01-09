package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.services.RegService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@AllArgsConstructor
public class AdminController {
    private RegService regService;

    @GetMapping("/admin-panel")
    public String getUsers(Model model, @RequestParam String type) {
        List<User> users;

        if ("today".equals(type)) {
            users = regService.findAllUsers().stream()
                    .filter(user -> user.getDateTime().getDayOfMonth() == LocalDateTime.now().getDayOfMonth())
                    .collect(Collectors.toList());
        } else if ("all".equals(type)) {
            users = regService.findAllUsers();
        } else {
            // Возвращаем пустой список, если тип неизвестен
            users = Collections.emptyList();
        }

        model.addAttribute("users", users);
        model.addAttribute("date", LocalDateTime.now());
        return "index";
    }

}
