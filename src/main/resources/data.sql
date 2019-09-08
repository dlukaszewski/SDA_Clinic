insert into ROLE (id, authority) values (nextval('role_seq'), 'PATIENT');
insert into ROLE (id, authority) values (nextval('role_seq'), 'DOCTOR');
insert into ROLE (id, authority) values (nextval('role_seq'), 'ADMIN');

insert INTO PATIENT (first_name, last_name, pesel,  password) values ('Jan','Kowalski', '87032518567','$2a$10$NfF6KA0UBxnOOIqwaV7Fser3ODx5.rzNw/Ip8EzXo/0OUQGmpUJYi');
insert INTO PATIENT (first_name, last_name, pesel,  password) values ('Tomasz','Nowak', '90061514627','$2a$10$NfF6KA0UBxnOOIqwaV7Fser3ODx5.rzNw/Ip8EzXo/0OUQGmpUJYi');

insert INTO DOCTOR (first_name, last_name, id, specialization) values ('Kamil', 'Wisniewski',nextval('doc_seq'), 'Internista');
insert INTO DOCTOR (first_name, last_name, id, specialization) values ('Piotr', 'Tomaszewski',nextval('doc_seq'), 'Internista');

insert INTO USER (user_name, password) values ('admin', '$2a$10$/LnMnVSE98bZQwYDKqTZfun//vfohkYEPeZC3rZeOSJUrIjzjVhO6');

insert INTO VISIT(id,appointment_date,patient_pesel,doctor_id) values (nextval('visit_seq'),parsedatetime('2019-09-15 10:00', 'yyyy-MM-dd hh:mm'),'87032518567',1);