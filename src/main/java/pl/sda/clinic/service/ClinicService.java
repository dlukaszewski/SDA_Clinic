package pl.sda.clinic.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.sda.clinic.model.Doctor;
import pl.sda.clinic.model.Patient;
import pl.sda.clinic.model.User;
import pl.sda.clinic.model.Visit;
import pl.sda.clinic.repository.DoctorRepository;
import pl.sda.clinic.repository.PatientRepository;
import pl.sda.clinic.repository.UserRepository;
import pl.sda.clinic.repository.VisitRepository;

import java.util.List;

@Service
public class ClinicService implements org.springframework.security.core.userdetails.UserDetailsService{

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final UserRepository userRepository;
    private final VisitRepository visitRepository;


    public ClinicService(DoctorRepository doctorRepository, PatientRepository patientRepository, UserRepository userRepository, VisitRepository visitRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.userRepository = userRepository;
        this.visitRepository = visitRepository;
    }

    public void addPatient(Patient patient) {
        patientRepository.save(patient);
    }
    public void addUser(User user){
        userRepository.save(user);
    }

    public List<Doctor> getDoctorList() {
        return doctorRepository.findAll();
    }

    public void addVisit(Visit visit) {
        visitRepository.save(visit);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findById(s).orElseThrow(() -> new UsernameNotFoundException("Could not foud User with username" + s));
    }
}
