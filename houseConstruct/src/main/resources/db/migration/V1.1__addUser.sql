INSERT INTO public.group (group_id, group_description) VALUES (1, 'Admin');
INSERT INTO public.group (group_id, group_description) VALUES (2, 'Kunde');
INSERT INTO public.group (group_id, group_description) VALUES (3, 'Architekt');
INSERT INTO public.group (group_id, group_description) VALUES (4, 'Möbelverkäufer');

INSERT INTO public.person (person_id, person_name, surname, email_adress) VALUES (1, 'Mini', 'Ader', 'AderMini@gmail.com');
INSERT INTO public.person (person_id, person_name, surname, email_adress) VALUES (2, 'Dieter', 'Kurt', 'KurtDieter@gmail.com');
INSERT INTO public.person (person_id, person_name, surname, email_adress, telephone_number) VALUES (3, 'Trek', 'Archie', 'ArchieTrek@gmail.com', '04176irgendeineNummer');
INSERT INTO public.person (person_id, person_name, surname, email_adress) VALUES (4, 'Vern', 'Mob', 'MobVern@gmail.com');

INSERT INTO public.user (user_id, user_password, fk_person_id, fk_group_id) VALUES (1, crypt('AdminTest', gen_salt('bf', 8)), 1, 1);
INSERT INTO public.user (user_id, user_password, fk_person_id, fk_group_id) VALUES (2, crypt('KundeTest', gen_salt('bf', 8)), 2, 2);
INSERT INTO public.user (user_id, user_password, fk_person_id, fk_group_id) VALUES (3, crypt('AchiTest', gen_salt('bf', 8)), 3, 3);
INSERT INTO public.user (user_id, user_password, fk_person_id, fk_group_id) VALUES (4, crypt('MöbelTest', gen_salt('bf', 8)), 4, 4);