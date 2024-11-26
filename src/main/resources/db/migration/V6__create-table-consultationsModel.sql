
create table consultationsmodel (
    id bigint not null auto_increment,
    physician_id bigint not null,
    patients_id bigint not null,
    date datetime not null,
    primary key (id),
    constraint fk_consultations_physician_id foreign key (physician_id) references physicianModel (id),
    constraint fk_consultations_patients_id foreign key (patients_id) references patientsModel (id)
);


