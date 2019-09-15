package pl.sda.clinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.clinic.model.*;
import pl.sda.clinic.repository.RoleRepository;
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

    @GetMapping("/accessDenied")
    public ModelAndView getAccesDeniedPage() {
        return new ModelAndView("accessDenied");
    }

    @GetMapping("/doctor")
    public ModelAndView getDoctorPage() {
        return new ModelAndView("doctor");
    }

    @GetMapping("/loginPage")
    public ModelAndView getLoginPage() {
        return new ModelAndView("loginPage");
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
        User user = patient.getUser();
        user.setRole(clinicService.findRoleByAuthority("PATIENT"));
        clinicService.addUser(user);
        clinicService.addPatient(patient);
        return "redirect:/loginPage";
    }

    @GetMapping("/patientPanel")
    public ModelAndView showDoctorsList() {
        List<Doctor> doctors = clinicService.getDoctorList();
        Visit visit = new Visit();
        ModelAndView modelAndView = new ModelAndView("patientPanel");
        modelAndView.addObject("doctors", doctors);
        modelAndView.addObject("visit", visit);
        return modelAndView;
    }

    @PostMapping("/addVisit")
    public String addVisit(@ModelAttribute Visit visit) {
        clinicService.addVisit(visit);
        return "redirect:/infoPage";
    }

    @GetMapping("/addDoctor")
    public ModelAndView createNewDoctor() {
        ModelAndView modelAndView = new ModelAndView("addDoctor");
        modelAndView.addObject("doctor", new Doctor());
        return modelAndView;
    }
    @PostMapping("/addDoctor")
    public String addDoctor(@ModelAttribute Doctor doctor) {
        User user = doctor.getUser();
        user.setRole(clinicService.findRoleByAuthority("DOCTOR"));
        clinicService.addUser(user);
        clinicService.addDoctor(doctor);
        return "redirect:/admin";
    }

    @GetMapping("/removeDoctor")
    public ModelAndView getDoctorList(){
        List<Doctor> doctors = clinicService.getDoctorList();
        ModelAndView modelAndView = new ModelAndView("removeDoctor");
        modelAndView.addObject("doctors",doctors);
        return modelAndView;
    }
    @GetMapping("/removeDoctor/{id}")
    public String removeDoctorFromList(@PathVariable Long id) {
        clinicService.removeDoctor(id);
        return "redirect:/removeDoctor";
    }
}

