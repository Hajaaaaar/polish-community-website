package com.example.resourcesPage.controller;

import com.example.resourcesPage.model.Resources;
import com.example.resourcesPage.service.ResourcesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ResourcesController {

    private final ResourcesService resourcesService;

    public ResourcesController(ResourcesService resourcesService) {
        this.resourcesService = resourcesService;
    }

    @GetMapping("/resources/resources")
    public String getResourcesPage(Model model) {
        List<Resources> resourcesList = resourcesService.getAllResources();
        model.addAttribute("resourcesList", resourcesList);
        return "Pages/resourcesPage";
    }
}
