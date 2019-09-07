package pl.sda.clinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.clinic.service.ClinicService;

@Controller
public class ClinicController {

private final ClinicService clinicService;

    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @GetMapping ("/")
    public ModelAndView getHomePage(){
        return new ModelAndView("home");
    }
    @GetMapping ("/admin")
    public ModelAndView getAdminPage(){
        return new ModelAndView("admin");
    }
    @GetMapping("/doctor")
    public ModelAndView getDoctorPage(){
        return  new ModelAndView("doctor");
    }
    @GetMapping("/patient")
    public ModelAndView getPatientPage(){
        return new ModelAndView("Patient");
    }

}
