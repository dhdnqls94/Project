create table boardtbl(
    bnum number primary key,
    bwriter varchar2(100),
    bemail varchar2(100),
    btitle varchar2(100),
    bpassword varchar2(100),
    bdate date,
    ref number,
    restep number,
    relevel number,
    readcount number,
    content varchar2(1000)
);

create SEQUENCE pboard_seq start with 1 INCREMENT by 1 maxvalue 5000;