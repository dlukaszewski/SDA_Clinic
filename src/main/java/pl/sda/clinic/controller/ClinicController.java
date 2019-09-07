package pl.sda.clinic.controller;

import org.springframework.stereotype.Controller;
import pl.sda.clinic.service.ClinicService;

@Controller
public class ClinicController {

private final ClinicService clinicService;

    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }


}
