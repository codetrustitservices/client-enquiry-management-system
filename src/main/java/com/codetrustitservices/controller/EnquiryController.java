package com.codetrustitservices.controller;

import com.codetrustitservices.model.Enquiry;
import com.codetrustitservices.service.EnquiryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EnquiryController {

    private final EnquiryService enquiryService;

    public EnquiryController(EnquiryService enquiryService) {
        this.enquiryService = enquiryService;
    }

    @GetMapping("/")
    public String home(){
        return "index";
    }

    // Edit Enquiry
    @GetMapping("/edit/{id}")
    public String editEnquiry(@PathVariable int id, Model model) {
        Enquiry enquiry = enquiryService.getEnquiryById(id);
        model.addAttribute("enquiry", enquiry);
        return "add-client";
    }

    // Update Enquiry
    @PostMapping("/update-enquiry")
    public String updateEnquiry(@ModelAttribute Enquiry enquiry) {
        enquiryService.updateEnquiry(enquiry);
        return "redirect:/admin";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("enquiry", new Enquiry());
        return "contact";
    }

    @PostMapping("/submit-enquiry")
    public String submitEnquiry(@ModelAttribute Enquiry enquiry){
        enquiryService.addEnquiry(enquiry);
        return "redirect:/admin";
    }

    @GetMapping("/admin")
    public String admin(Model model){
        model.addAttribute("enquiries" , enquiryService.getAllEnquiry());
        return "admin";
     }

    // Delete Enquiry
    @GetMapping("/delete/{id}")
     public String delete(@PathVariable int id){
        enquiryService.deleteEnquiry(id);
        return "redirect:/admin";
     }


    @GetMapping("/add-client")
    public String addClientPage(Model model) {
        model.addAttribute("enquiry", new Enquiry());
        return "add-client";
    }


    // View All Clients/Enquiries
    @GetMapping("/clients")
    public String listClients(Model model) {
        model.addAttribute("clients", enquiryService.getAllEnquiry());
        return "clients";
    }


}
