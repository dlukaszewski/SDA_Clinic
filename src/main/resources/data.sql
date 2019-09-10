insert into ROLE (id, authority) values (nextval('role_seq'), 'PATIENT');
insert into ROLE (id, authority) values (nextval('role_seq'), 'DOCTOR');
insert into ROLE (id, authority) values (nextval('role_seq'), 'ADMIN');

insert INTO PATIENT (first_name, last_name, pesel) values ('Jan','Kowalski', '87032518567');
insert INTO PATIENT (first_name, last_name, pesel) values ('Tomasz','Nowak', '90061514627');

insert INTO DOCTOR (first_name, last_name, id, specialization) values ('Kamil', 'Wisniewski',nextval('doc_seq'), 'Internista');
insert INTO DOCTOR (first_name, last_name, id, specialization) values ('Piotr', 'Tomaszewski',nextval('doc_seq'), 'Internista');

insert INTO USER (username, password) values ('admin', '$2a$10$6Uwop6rBqC0/A5p93zpfRuHo/ikJ.KuBUMTcOpaDE/nNF3jqrfuYm');

insert INTO USER (username,password) values ('patient','$2a$10$6Uwop6rBqC0/A5p93zpfRuHo/ikJ.KuBUMTcOpaDE/nNF3jqrfuYm' );
insert INTO USER (username,password) values ('patient1','$2a$10$6Uwop6rBqC0/A5p93zpfRuHo/ikJ.KuBUMTcOpaDE/nNF3jqrfuYm' );

insert INTO VISIT(id,appointment_date,patient_pesel,doctor_id) values (nextval('visit_seq'),parsedatetime('2019-09-15 10:00', 'yyyy-MM-dd hh:mm'),'87032518567',1);