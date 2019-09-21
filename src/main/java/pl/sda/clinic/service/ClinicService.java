package pl.sda.clinic.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.sda.clinic.model.*;
import pl.sda.clinic.repository.*;


import java.util.List;
import java.util.Optional;

@Service
public class ClinicService implements org.springframework.security.core.userdetails.UserDetailsService{

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final UserRepository userRepository;
    private final VisitRepository visitRepository;
    private final RoleRepository roleRepository;


    public ClinicService(DoctorRepository doctorRepository, PatientRepository patientRepository, UserRepository userRepository, VisitRepository visitRepository, RoleRepository roleRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.userRepository = userRepository;
        this.visitRepository = visitRepository;
        this.roleRepository = roleRepository;
    }

    public void addPatient(Patient patient) {
        User user = patient.getUser();
        user.setRole(findRoleByAuthority("PATIENT"));
        addUser(user);
        patientRepository.save(patient);
    }
    public void addUser(User user){
        userRepository.save(user);
    }
    public void addDoctor(Doctor doctor){
        User user = doctor.getUser();
        user.setRole(findRoleByAuthority("DOCTOR"));
        addUser(user);
        doctorRepository.save(doctor);
    }
    public void removeDoctor(Long id){
        doctorRepository.deleteById(id);
    }
    public void findDoctorById(Long id){
        doctorRepository.findById(id);
    }
    public void removePatient(Long pesel){
        patientRepository.deleteById(pesel);
    }
    public Patient getPatientByUserName(String username){
        return patientRepository.searchByUserUserName(username).orElseThrow(() -> new RuntimeException("sfh"));
    }
    public List<Doctor> getDoctorList() {
        return doctorRepository.findAll();
    }
    public List<Patient> getPatientList(){
        return patientRepository.findAll();
    }
    public List<Visit> getVisitList(){return visitRepository.findAll();}


    public void addVisit(Visit visit) {
        visitRepository.save(visit);
    }

    public List<Visit> getNotBookedVisit(Long doctorId){
        return visitRepository.searchNotBookedVisit(doctorId);//id doctora
    }

    public Visit findVisitById(Long id){
        return visitRepository.findById(id).orElseThrow(() ->new UsernameNotFoundException("Could not found Visit with ID" + id));
    }
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findById(s).orElseThrow(() -> new UsernameNotFoundException("Could not foud User with username" + s));
    }

    public Role findRoleByAuthority (String authority) throws UsernameNotFoundException{
        return roleRepository.findByAuthority(authority).orElseThrow(()->new UsernameNotFoundException("Could not found authority"+ authority));
        }

    public void removeVisit(Long id) {
        visitRepository.deleteById(id);
    }
}
