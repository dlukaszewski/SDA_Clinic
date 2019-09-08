package pl.sda.clinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.clinic.model.Doctor;
import pl.sda.clinic.model.Patient;
import pl.sda.clinic.model.Visit;
import pl.sda.clinic.service.ClinicService;

import java.util.List;

@Controller
public class ClinicController {

    private final ClinicService clinicService;


    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @GetMapping("/")
    public ModelAndView getHomePage() {
        return new ModelAndView("home");
    }

    @GetMapping("/admin")
    public ModelAndView getAdminPage() {
        return new ModelAndView("admin");
    }

    @GetMapping("/doctor")
    public ModelAndView getDoctorPage() {
        return new ModelAndView("doctor");
    }

    @GetMapping("/patientLogin")
    public ModelAndView getPatientPage() {
        return new ModelAndView("patientLogin");
    }
    @GetMapping("/infoPage")
    public ModelAndView getInfoPage() {
        return new ModelAndView("infoPage");
    }

    @GetMapping("/addPatient")
    public ModelAndView createNewPatient() {
        ModelAndView modelAndView = new ModelAndView("addPatient");
        modelAndView.addObject("patient", new Patient());
        return modelAndView;
    }
    @PostMapping("/addPatient")
    public String addPatient(@ModelAttribute Patient patient) {
        clinicService.addPatient(patient);
        return "redirect:/patientLogin";
    }
    @GetMapping("/patientPanel")
    public ModelAndView showDoctorsList() {
        List<Doctor> doctors = clinicService.getDoctorList();
        Visit visit = new Visit();
        ModelAndView modelAndView = new ModelAndView("patientPanel");
        modelAndView.addObject("doctors", doctors);
        modelAndView.addObject("visit",visit);
        return modelAndView;
    }
    @PostMapping("/addVisit")
    public String addVisit(@ModelAttribute Visit visit){
        clinicService.addVisit(visit);
        return "redirect:/infoPage";
    }
}


