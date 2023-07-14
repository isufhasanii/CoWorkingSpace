INSERT INTO admin (name, username, password) VALUES ('Adi Minster', 'adimin', "8953");
INSERT INTO admin (name, username, password) VALUES ('Java Python', 'javpyt', "8952");

INSERT INTO raum (name, ausstattung) VALUES ('Meeting Room 1', 'Beamer, Whiteboard');
INSERT INTO raum (name, ausstattung) VALUES ('Workspace 2', 'Schreibtisch, Stuhl');

INSERT INTO buchung (datum, zeitraum, member_id, raum_id) VALUES ('2023-07-15', 120, 1, 1);
INSERT INTO buchung (datum, zeitraum, member_id, raum_id) VALUES ('2023-07-16', 60, 2, 2);

INSERT INTO buchungsanfrage (datum, status, member_id, raum_id) VALUES ('2023-07-18', 'Ausstehend', 1, 2);
INSERT INTO buchungsanfrage (datum, status, member_id, raum_id) VALUES ('2023-07-19', 'Abgelehnt', 2, 1);

INSERT INTO mitglied (vorname, nachname, email, passwort) VALUES ('Schmid', 'Gliged', 'schmid@example.com', 'pass123');
INSERT INTO mitglied (vorname, nachname, email, passwort) VALUES ('Bea', 'Sucher', 'bea@example.com', 'pass456');