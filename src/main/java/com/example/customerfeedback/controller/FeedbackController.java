package com.example.customerfeedback.controller;

import com.example.customerfeedback.model.Feedback;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FeedbackController {

    @GetMapping("/feedback")
    public String showFeedbackForm(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "feedbackform";
    }

    @PostMapping("/submitfeedback")
    public String submitFeedback(@ModelAttribute("feedback") @Valid Feedback feedback, Model model, BindingResult result) {
        System.out.println("Visit Date (Before binding): " + feedback.getVisitDate());

        if (result.hasErrors()) {
            System.out.println("Errors: " + result.getAllErrors());
            return "feedbackform";
        }

        model.addAttribute("feedback", feedback);
        return "confirmationPage";
    }

}
