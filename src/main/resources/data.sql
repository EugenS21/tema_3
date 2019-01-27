insert into Lessons (ID, Nume) values
(1, 'Engleza'),
(2, 'Romana'),
(3, 'Matematica'),
(4, 'Istoria'),
(5, 'Fizica'),
(6, 'Chimia'),
(7, 'Informatica');

insert into Students (ID,Nume,Prenume, Gen) values
(1,'Vieru','Vasile', ''),
(2,'Savca','Eugen',''),
(3, 'Revenco', 'Alexandrina',''),
(4, 'Ion', 'Ababii',''),
(5, 'Alex', 'Gamurari','');

insert into Marks (ID, Mark, ID_Student, ID_Lectie) values
(1, 9, 1, 1),
(2, 8, 1, 2),
(3, 7, 2, 1),
(4, 6, 2, 2),
(5, 10, 5, 6);