insert into ROLE (id, authority) values (nextval('role_seq'), 'PATIENT');
insert into ROLE (id, authority) values (nextval('role_seq'), 'DOCTOR');
insert into ROLE (id, authority) values (nextval('role_seq'), 'ADMIN');

insert INTO PATIENT (firstName, lastName, patientId, appointmentDate, password) values ('Jan','Kowalski', '87032518567',2019-09-15 10:00:00,'$2a$10$NfF6KA0UBxnOOIqwaV7Fser3ODx5.rzNw/Ip8EzXo/0OUQGmpUJYi');
insert INTO PATIENT (firstName, lastName, patientId, appointmentDate, password) values ('Tomasz','Nowak', '90061514627',2019-09-15 11:00:00,'$2a$10$NfF6KA0UBxnOOIqwaV7Fser3ODx5.rzNw/Ip8EzXo/0OUQGmpUJYi');

insert INTO DOCTOR (firstName, lastName, doctorId, specialization, password) values ('Kamil', 'Wisniewski', 1, 'Internista', '$2a$10$NfF6KA0UBxnOOIqwaV7Fser3ODx5.rzNw/Ip8EzXo/0OUQGmpUJYi');
insert INTO DOCTOR (firstName, lastName, doctorId, specialization, password) values ('Piotr', 'Tomaszewski', 2, 'Internista', '$2a$10$NfF6KA0UBxnOOIqwaV7Fser3ODx5.rzNw/Ip8EzXo/0OUQGmpUJYi');

insert INTO USER (username, password, id) values ('admin', '$2a$10$/LnMnVSE98bZQwYDKqTZfun//vfohkYEPeZC3rZeOSJUrIjzjVhO6', 1);