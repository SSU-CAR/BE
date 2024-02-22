insert into scenario (scenario_id, flag, name, weight, total) values (1, 1, '전방 주시 태만', 2, 0);
insert into scenario (scenario_id, flag, name, weight, total) values (2, 1, '핸드폰 사용', 3, 0);
insert into scenario (scenario_id, flag, name, weight, total) values (3, 1, '졸음 운전', 8, 0);
insert into scenario (scenario_id, flag, name, weight, total) values (51, 2, '방향지시등 안 켜고 차선변경', 3, 0);
insert into scenario (scenario_id, flag, name, weight, total) values (52, 2, '실선에서 차선변경', 3, 0);

insert into mobility.badge (badge_id, status, name, caption, goal, number) values (1, 0, '안전운전 뉴비', '첫 주행을 마치셨네요. 앞으로의 안전한 주행 응원할게요!', 1, 0);
insert into mobility.badge (badge_id, status, name, caption, goal, number) values (2, 0, '베스트 드라이버', '10번이나 90점 이상의 점수를 받으셨어요! 안전운전이 습관이 되셨네요.', 10, 0);
insert into mobility.badge (badge_id, status, name, caption, goal, number) values (3, 0, '만점 주행자', '점수 100점을 달성하셨네요, 정말 대단해요!!', 1, 0);
insert into mobility.badge (badge_id, status, name, caption, goal, number) values (4, 0, '도로 위의 신사', '100km이상의 주행동안 문제 상황이 10번 미만이었어요. 정말 대단해요!!', 1, 0);
insert into mobility.badge (badge_id, status, name, caption, goal, number) values (5, 0, '아빠 안 잔다', '졸음 운전 없이 10번의 주행을 마치셨어요. 운전 중 졸음은 절대 금물!', 10, 0);
insert into mobility.badge (badge_id, status, name, caption, goal, number) values (6, 0, '운전의 신', '모든 배지를 획득하셨어요! 앞으로도 잘 부탁드려요 :)', 1, 0);


insert into report (report_id, mileage, score, departured_at, arrived_at) values (1, 61, 78, '2024-02-10 09:10:33', '2024-02-10 11:03:50');
insert into report (report_id, mileage, score, departured_at, arrived_at) values (2, 34, 73, '2024-02-17 18:10:25', '2024-02-17 19:03:11');

insert into risk (report_id, risk_id, scenario_type, created_at) values (1, 1, 1, '2024-02-10 09:17:25');
insert into risk (report_id, risk_id, scenario_type, created_at) values (1, 2, 2, '2024-02-10 09:30:44');
insert into risk (report_id, risk_id, scenario_type, created_at) values (1, 3, 3, '2024-02-10 09:47:05');
insert into risk (report_id, risk_id, scenario_type, created_at) values (1, 4, 51, '2024-02-10 10:02:24');
insert into risk (report_id, risk_id, scenario_type, created_at) values (1, 5, 52, '2024-02-10 10:12:02');
insert into risk (report_id, risk_id, scenario_type, created_at) values (1, 6, 52, '2024-02-10 10:35:54');
insert into risk (report_id, risk_id, scenario_type, created_at) values (1, 7, 52, '2024-02-10 11:00:32');
insert into risk (report_id, risk_id, scenario_type, created_at) values (2, 8, 51, '2024-02-17 18:15:25');
insert into risk (report_id, risk_id, scenario_type, created_at) values (2, 9, 51, '2024-02-17 18:17:32');
insert into risk (report_id, risk_id, scenario_type, created_at) values (2, 10, 51, '2024-02-17 18:30:24');
insert into risk (report_id, risk_id, scenario_type, created_at) values (2, 11, 51, '2024-02-17 18:32:41');
insert into risk (report_id, risk_id, scenario_type, created_at) values (2, 12, 51, '2024-02-17 18:41:32');
insert into risk (report_id, risk_id, scenario_type, created_at) values (2, 13, 1, '2024-02-17 18:55:21');
insert into risk (report_id, risk_id, scenario_type, created_at) values (2, 14, 2, '2024-02-17 18:57:01');
insert into risk (report_id, risk_id, scenario_type, created_at) values (2, 15, 3, '2024-02-17 19:02:02');

insert into summary (report_id, scenario_type, summary_count, summary_id, scenario_name) values (1, 1, 1, 1, '전방 주시 태만');
insert into summary (report_id, scenario_type, summary_count, summary_id, scenario_name) values (1, 2, 1, 2, '핸드폰 사용');
insert into summary (report_id, scenario_type, summary_count, summary_id, scenario_name) values (1, 3, 1, 3, '졸음 운전 ');
insert into summary (report_id, scenario_type, summary_count, summary_id, scenario_name) values (1, 51, 1, 4, '방향지시등 안 켜고 차선변경');
insert into summary (report_id, scenario_type, summary_count, summary_id, scenario_name) values (1, 52, 3, 5, '실선에서 차선변경');
insert into summary (report_id, scenario_type, summary_count, summary_id, scenario_name) values (2, 51, 5, 6, '방향지시등 안 켜고 차선변경');
insert into summary (report_id, scenario_type, summary_count, summary_id, scenario_name) values (2, 1, 1, 7, '전방 주시 태만');
insert into summary (report_id, scenario_type, summary_count, summary_id, scenario_name) values (2, 2, 1, 8, '핸드폰 사용');
insert into summary (report_id, scenario_type, summary_count, summary_id, scenario_name) values (2, 3, 1, 9, '졸음 운전');







