package pl.sda.clinic.service;

import org.springframework.stereotype.Service;
import pl.sda.clinic.repository.DoctorRepository;
import pl.sda.clinic.repository.PatientRepository;
import pl.sda.clinic.repository.UserRepository;

@Service
public class ClinicService {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final UserRepository userRepository;

    public ClinicService(DoctorRepository doctorRepository, PatientRepository patientRepository,UserRepository userRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.userRepository = userRepository;
    }
}
