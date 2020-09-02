create table product1(
    no number primary key,
    name varchar2(50),
    category number,
    price number,
    img varchar2(50),
    info varchar2(100)
);
create SEQUENCE deliver1_seq start with 1500 INCREMENT by 1 maxvalue 10000;
insert into product values(pboard_seq.nextval, '멜트블로운 마스크', 1, 7900, '마스크1.jpg', 'BUEHN 고급형 멜트블로운 마스크입니다.');
insert into product values(pboard_seq.nextval,'쿨냉감 항균 마스크', 1, 10240, '마스크2.jpg', '쿨냉감 항균 패션마스크입니다.');
insert into product values(pboard_seq.nextval,'휴스퍼트 마스크', 1, 5990, '마스크3.jpg', '휴스퍼트 마스크입니다.');
insert into product values(pboard_seq.nextval,'웹클린 KF94마스크', 1, 5000, '마스크4.jpg', '웹클린 KF94 여름용 방역마스크입니다.');


insert into product values(pboard_seq.nextval,'뷰티끄랩 전기면도기', 2, 59000, '면도기1.jpg', '뷰티끄랩 스마트4IN1 전기면도기입니다.');
insert into product values(pboard_seq.nextval,'질레트 퓨전 옐로우면도기', 2, 13760, '면도기2.jpg', '질레트 퓨전 옐로우면도기입니다.');
insert into product values(pboard_seq.nextval,'오랄비칫솔', 2, 13100, '칫솔1.jpg', '오랄비 크로스액션 초소형헤드 칫솔입니다.');
insert into product values(pboard_seq.nextval,'리스테린 구강청결제', 2, 18900, '구강청결1.jpg', '리스테린 쿨민트 구강청결제입니다.');


insert into product values(pboard_seq.nextval,'클리오 구달 청귤비타C 토너', 3, 25900, '토너1.jpg', '클리오 구달 청귤 비타C 토너 패드입니다.');
insert into product values(pboard_seq.nextval,'센카 스피디 퍼펙트 클랜징폼', 3, 15900, '클랜징폼1.jpg', '센카 스피디 퍼펙트 휨 클렌징폼입니다.');
insert into product values(pboard_seq.nextval,'해피바스 화이트로즈 바디워시', 3, 15010, '바디워시1.jpg', '해피바스 화이트로즈 에센스 바디워시입니다.');
insert into product values(pboard_seq.nextval,'해피바스 라벤더 에센스 바디워시', 3, 14200, '바디워시2.jpg', '해피바스 라벤더 에센스 모이스춰 바입니다.');


insert into product values(pboard_seq.nextval,'에코스 스테인리스 클리너', 4, 7400, '클리너1.jpg', '에코스 스테인리스 스틸 클리너입니다.');
insert into product values(pboard_seq.nextval,'한입 100% 구연산', 4, 9900, '클리너2.jpg', '한입 100% 구연산 클리너입니다.');
insert into product values(pboard_seq.nextval,'매직캔 리필 쓰레기봉투', 4, 19800, '쓰레기봉투1.jpg', '매직캔 리필 쓰레기봉투입니다.');
insert into product values(pboard_seq.nextval,'메소드 다목적 세정제', 4, 10200, '세정제1.jpg', '메소드 다목적 세정제 프렌치라벤더입니다.');