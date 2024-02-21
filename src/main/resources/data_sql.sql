insert into scenario (scenario_id, flag, name, weight, total) values (1, 1, '졸음 운전 (고개)', 2, 0);
insert into scenario (scenario_id, flag, name, weight, total) values (2, 1, '핸드폰 사용', 3, 0);
insert into scenario (scenario_id, flag, name, weight, total) values (3, 1, '졸음 운전 (눈)', 5, 0);
insert into scenario (scenario_id, flag, name, weight, total) values (51, 2, '방향지시등 안 켜고 차선변경', 3, 0);
insert into scenario (scenario_id, flag, name, weight, total) values (52, 2, '실선에서 차선변경', 3, 0);

insert into mobility.badge (badge_id, status, name, caption, goal, number) values (1, 0, '안전운전 뉴비', '첫 주행을 마치셨네요. 앞으로의 안전한 주행 응원할게요!', 1, 0);
insert into mobility.badge (badge_id, status, name, caption, goal, number) values (2, 0, '베스트 드라이버', '10번이나 90점 이상의 점수를 받으셨어요! 안전운전이 습관이 되셨네요.', 10, 0);
insert into mobility.badge (badge_id, status, name, caption, goal, number) values (3, 0, '만점 주행자', '점수 100점을 달성하셨네요, 정말 대단해요!!', 1, 0);
insert into mobility.badge (badge_id, status, name, caption, goal, number) values (4, 0, '도로 위의 신사', '100km이상의 주행동안 문제 상황이 10번 미만이었어요. 정말 대단해요!!', 1, 0);
insert into mobility.badge (badge_id, status, name, caption, goal, number) values (5, 0, '아빠 안 잔다', '졸음 운전 없이 10번의 주행을 마치셨어요. 운전 중 졸음은 절대 금물!', 10, 0);
insert into mobility.badge (badge_id, status, name, caption, goal, number) values (6, 0, '운전의 신', '모든 배지를 획득하셨어요! 앞으로도 잘 부탁드려요 :)', 1, 0);