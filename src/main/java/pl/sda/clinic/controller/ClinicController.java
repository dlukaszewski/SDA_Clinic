package pl.sda.clinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.clinic.model.*;
import pl.sda.clinic.service.ClinicService;
import pl.sda.clinic.service.SessionUserProvider;

import java.util.List;
import java.util.Optional;

@Controller
public class ClinicController {

    private final ClinicService clinicService;
    private final SessionUserProvider sessionUserProvider;

    public ClinicController(ClinicService clinicService, SessionUserProvider sessionUserProvider) {
        this.clinicService = clinicService;
        this.sessionUserProvider = sessionUserProvider;
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
        clinicService.addPatient(patient);
        return "redirect:/loginPage";
    }

    @GetMapping("/patientPanel")
    public ModelAndView showDoctorsList(@RequestParam(required = false) Long doctorId) {
        List<Doctor> doctors = clinicService.getDoctorList();
        List<Visit> docVisits = doctorId == null ? clinicService.getVisitList() : clinicService.getNotBookedVisit(doctorId);
//        if (doctorId == null) {
//            return clinicService.getVisitList();
//        } else {
//            return clinicService.getNotBookedVisit(doctorId);
//        }
        ModelAndView modelAndView = new ModelAndView("patientPanel");
        modelAndView.addObject("doctors", doctors);
        modelAndView.addObject("docVisits", docVisits);
        return modelAndView;
    }
    @GetMapping("/workSchedule")
    public ModelAndView workSchedulePage() {
        List<Doctor> doctors = clinicService.getDoctorList();
        List<Visit> visits = clinicService.getVisitList();
        Visit visit = new Visit();
        ModelAndView modelAndView = new ModelAndView("workSchedule");
        modelAndView.addObject("doctors", doctors);
        modelAndView.addObject("visit", visit);
        modelAndView.addObject("visits",visits);
        return modelAndView;
    }
    @PostMapping("/workSchedule")
    public String workSchedule(@ModelAttribute Visit visit){
        clinicService.addVisit(visit);
        return "redirect:/workSchedule";
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
    @GetMapping("/patientPanel/doctors/{id}")
    public String getDoctorVisitList(@PathVariable Long id){
        clinicService.findDoctorById(id);
        return  "redirect:/patientPanel";
    }
    @GetMapping("/removeVisit/{id}")
    public String removeVisitFromList(@PathVariable Long id) {
        clinicService.removeVisit(id);
        return "redirect:/workSchedule";
    }

    @GetMapping("/removePatient")
    public ModelAndView getPatientList(){
        List<Patient> patients = clinicService.getPatientList();
        ModelAndView modelAndView = new ModelAndView("removePatient");
        modelAndView.addObject("patients",patients);
        return modelAndView;
    }
    @GetMapping("/removePatient/{pesel}")
    public String removePatientFromList(@PathVariable Long pesel) {
        clinicService.removePatient(pesel);
        return "redirect:/removePatient";
    }
    @GetMapping("/onclick")
    public ModelAndView onClickPage(){
        return new ModelAndView("onclick");
    }

    @GetMapping("/book/{visitId}")
    public String bookVisit(@PathVariable long visitId) {
        User loggedUser = sessionUserProvider.getLoggedUser();//aktualny zalogowany user
        String username = loggedUser.getUsername();//przekazanie username
        Patient patientByUserName = clinicService.getPatientByUserName(username);//pobieram pacjenta po nazwie username
        Visit visitById = clinicService.findVisitById(visitId);//pobranie wizyty po identyfikatorze
        visitById.setPatient(patientByUserName);// ustawienie w wizycie konkretnego pacjenta
        clinicService.addVisit(visitById);
        return "redirect:/patientPanel";
    }

}

