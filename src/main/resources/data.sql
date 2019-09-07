insert into ROLE (id, authority) values (nextval('role_seq'), 'PATIENT');
insert into ROLE (id, authority) values (nextval('role_seq'), 'DOCTOR');
insert into ROLE (id, authority) values (nextval('role_seq'), 'ADMIN');

insert INTO PATIENT (first_name, last_name, pesel, appointment_date, password) values ('Jan','Kowalski', '87032518567',parsedatetime('2019-09-15 10:00:00', 'yyyy-MM-dd hh:mm:ss'),'$2a$10$NfF6KA0UBxnOOIqwaV7Fser3ODx5.rzNw/Ip8EzXo/0OUQGmpUJYi');
insert INTO PATIENT (first_name, last_name, pesel, appointment_date, password) values ('Tomasz','Nowak', '90061514627',parsedatetime('2019-09-15 10:00:00', 'yyyy-MM-dd hh:mm:ss'),'$2a$10$NfF6KA0UBxnOOIqwaV7Fser3ODx5.rzNw/Ip8EzXo/0OUQGmpUJYi');

insert INTO DOCTOR (first_name, last_name, id, specialization) values ('Kamil', 'Wisniewski', 1, 'Internista');
insert INTO DOCTOR (first_name, last_name, id, specialization) values ('Piotr', 'Tomaszewski', 2, 'Internista');

insert INTO USER (user_name, password) values ('admin', '$2a$10$/LnMnVSE98bZQwYDKqTZfun//vfohkYEPeZC3rZeOSJUrIjzjVhO6');