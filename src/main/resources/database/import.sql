
create table EVENT(
    ID int,
    TITLE VARCHAR(255),
    START DATETIME,
    END DATETIME,
    DESCRIPTION VARCHAR(255)

);
insert into EVENT (ID , TITLE, START, END, DESCRIPTION) values (1, 'event1', '2019-01-01 1:00:00', '2019-01-01 2:00:00', 'description1');
insert into EVENT (ID, TITLE, START, END, DESCRIPTION) values (2, 'event2', '2019-01-02 2:00:00', '2019-01-02 3:00:00', 'description1');
insert into EVENT (ID, TITLE, START, END, DESCRIPTION) values (3, 'event3', '2019-01-03 1:00:00', '2019-01-03 2:00:00', 'description1');
insert into EVENT (ID, TITLE, START, END, DESCRIPTION) values (4, 'event4', '2019-01-04 1:00:00', '2019-01-04 2:00:00', 'description1');


