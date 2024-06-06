package net.proselyte.fileservice.controller;

import net.proselyte.fileservice.dto.PostDto;
import net.proselyte.fileservice.service.FileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {
    private final FileService fileService;

    public PostController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("post", new PostDto(null, null));
        return "form";
    }

    @GetMapping("/payload")
    public String showPayload(Model model) {
        String payload = fileService.readFromFile();
        model.addAttribute("payload", payload);
        return "payload";
    }

    @PostMapping("/form")
    public String submitForm(PostDto post) {
        fileService.writeToFile(post);
        return "redirect:/success";
    }

    @GetMapping("/success")
    public String showSuccess() {
        return "success";
    }

    @GetMapping("/exit")
    public String exit() {
        System.exit(1);
        return null;
    }
}
