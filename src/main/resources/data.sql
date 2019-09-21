insert into ROLE (id, authority) values (nextval('role_seq'), 'PATIENT');
insert into ROLE (id, authority) values (nextval('role_seq'), 'DOCTOR');
insert into ROLE (id, authority) values (nextval('role_seq'), 'ADMIN');
insert INTO USER (username, password,role_id) values ('admin', '$2a$10$6Uwop6rBqC0/A5p93zpfRuHo/ikJ.KuBUMTcOpaDE/nNF3jqrfuYm',3);

insert INTO USER (username,password,role_id) values ('patient','$2a$10$6Uwop6rBqC0/A5p93zpfRuHo/ikJ.KuBUMTcOpaDE/nNF3jqrfuYm',1 );
insert INTO USER (username,password,role_id) values ('patient1','$2a$10$6Uwop6rBqC0/A5p93zpfRuHo/ikJ.KuBUMTcOpaDE/nNF3jqrfuYm',1 );
insert INTO USER (username,password,role_id) values ('doctor','$2a$10$6Uwop6rBqC0/A5p93zpfRuHo/ikJ.KuBUMTcOpaDE/nNF3jqrfuYm',2 );
insert INTO USER (username,password,role_id) values ('doctor1','$2a$10$6Uwop6rBqC0/A5p93zpfRuHo/ikJ.KuBUMTcOpaDE/nNF3jqrfuYm',2 );

insert INTO PATIENT (first_name, last_name, pesel, user_username) values ('Jan','Kowalski', '87032518567', 'patient');
insert INTO PATIENT (first_name, last_name, pesel, user_username) values ('Tomasz','Nowak', '90061514627', 'patient1');


insert INTO DOCTOR (first_name, last_name, id, specialization, user_username) values ('Kamil', 'Wisniewski',nextval('doc_seq'), 'Internista','doctor');
insert INTO DOCTOR (first_name, last_name, id, specialization, user_username) values ('Piotr', 'Tomaszewski',nextval('doc_seq'), 'Internista','doctor1');

insert INTO VISIT(id,appointment_date,doctor_id) values (nextval('visit_seq'),parsedatetime('2019-09-15 10:00', 'yyyy-MM-dd hh:mm'),1);
commit;