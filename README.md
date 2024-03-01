# 안전운전 피드백 서비스
### 🚘 현대모비스 2024 Mobility SW HACKATHON 
> **2024.01.18~2024.02.23**


## 👥 팀 소개
|![김정우](https://github.com/jwo0o0.png)|![맹영욱](https://github.com/0woogie.png)|![백서현](https://github.com/Seohyun-Back.png)|![김병지](https://github.com/byungjikim.png)|
|:--:|:--:|:--:|:--:|
|[김정우](https://github.com/jwo0o0)|[맹영욱](https://github.com/0woogie)|[백서현](https://github.com/Seohyun-Back)|[김병지](https://github.com/byungjikim)|
|Frontend|Backend|Backend|Embedded|



## 📌 프로젝트 소개

전방 주시 태만을 비롯한 안전운전 불이행은 교통사고의 주 원인이다.<br>
또한, 현재 상용화된 자율주행 레벨2, 레벨3에서 운전자는 여전히 시스템의 직접 운전 요구에 대응해야 할 의무가 있다. <br>
따라서 <b>사용자의 안전운전을 위해 운전 습관을 피드백해주는 모빌리티 SW를 기획</b>하였다.<br> 

차량 센서와 내부 카메라로 <b>차량 내/외부의 위험한 운전 상황과 운전자 자세 (e.g. 실선에서의 차선변경, 전방 주시 태만 등)를 감지</b>한다. <br>
이 데이터를 바탕으로 <b>운전 점수를 산정하고, 주행 리포트를 제공</b>한다. <br>
추가적으로 다양한 운전 배지 획득을 통해 안전 운전에 대한 성취감과 동기 부여를 제공하는 모바일 웹 서비스를 기획했다. 

<img width="600" alt="img1" src="https://github.com/SSU-CAR/.github/assets/70098708/44b829cc-cd47-434a-b9f5-b22f7da318bf">

<img width="600" alt="img2" src="https://github.com/SSU-CAR/.github/assets/70098708/3a59922c-b9fa-4486-9a1c-ba1d0b5401ff">

## 🔍 화면 구성 및 기능

| 홈 | 주행 중 | 주행 후|
|:---:|:---:|:---:|
| <img width="250" alt="home" src="https://github.com/SSU-CAR/.github/assets/70098708/156c43b8-0137-4b35-9182-3a9632a68765"> | <img width="250" alt="주행 중" src="https://github.com/SSU-CAR/.github/assets/70098708/69e229b0-6fee-46d7-85d2-8b1eb54d3107"> | <img width="250" alt="주행 후" src="https://github.com/SSU-CAR/.github/assets/70098708/110e62f7-35d6-442d-ac2a-f9931b097c4a"> |
|운전점수, 주의해야 할 운전습관, 주행 코멘트 등<br>사용자의 전반적인 현재 상태와 주행 기록 확인|차량에서 주행에 대한 운전 정보를 수집<br>RC카-서버 통신으로 주행 정보 DB 저장|주행에서 누적된 데이터를 주행이 후 즉시 확인<br>감지된 운전 습관과 횟수를 제공|

| 주행 기록 | 주행 리포트 | 배지 |
|:---:|:---:|:---:|
|<img width="250" alt="주행 기록" src="https://github.com/SSU-CAR/.github/assets/70098708/68832251-939b-40a7-af45-e461b031ce7d">|<img width="250" alt="주행 리포트" src="https://github.com/SSU-CAR/.github/assets/70098708/95f3a34b-4540-4229-a90e-b6b06a7fd51e">|<img width="250" alt="배지" src="https://github.com/SSU-CAR/.github/assets/70098708/9daa8dc6-d178-44fd-ba9d-9588a01cffb2">|
|사용자의 지금까지 주행을 기록<br>각 주행에서 감지된 운전 습관과 횟수를 확인|누적된 주행 데이터를 통해 얻은 사용자의 전반적인<br> 운전 습관 피드백, 그래프 통계 제공<br>주행 이력, 월별 운전 점수 현황, 월별 주행 이력 및<br> 주의해야 할 운전 습관 등|주행 시 특정 조건을 충족하면 배지 획득<br>사용자에게 동기부여와 재미 요소 추가|









### 📹 시연 영상
https://github.com/SSU-CAR/.github/assets/70098708/da9842e9-05d1-4aa0-b273-bea88a6baa1e



## 🛠️ Stacks
### Front
<img src="https://img.shields.io/badge/Typescript-3178C6?style=flat&logo=typescript&logoColor=white"/> <img src="https://img.shields.io/badge/React-61DAFB?style=flat&logo=react&logoColor=white"/> <img src="https://img.shields.io/badge/chart.js-FF6384?style=flat&logo=chartdotjs&logoColor=white"/> <img src="https://img.shields.io/badge/Styled Components-DB7093?style=flat&logo=styled-components&logoColor=white"/> <img src="https://img.shields.io/badge/S3-569A31?style=flat&logo=amazons3&logoColor=white"/>
<img src="https://img.shields.io/badge/GithubActions-2088FF?style=flat&logo=githubactions&logoColor=white"/> 
### Back
<img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=flat&logo=openjdk&logoColor=white"/> <img src="https://img.shields.io/badge/spring-%236DB33F.svg?style=flat&logo=spring&logoColor=white"/> <img src="https://img.shields.io/badge/mysql-%2300f.svg?style=flat&logo=mysql&logoColor=white"/> <img src="https://img.shields.io/badge/AWS-%23FF9900.svg?style=flat&logo=amazon-aws&logoColor=white"/> <img src="https://img.shields.io/badge/Postman-FF6C37?style=flat&logo=postman&logoColor=white"/> <img src="https://img.shields.io/badge/GithubActions-2088FF?style=flat&logo=githubactions&logoColor=white"/> 
### Embedded
![ROS2](https://img.shields.io/badge/ros-foxy-444444?style=flat&logo=ros)
![Python](https://img.shields.io/badge/Python-444444?style=flat&logo=Python)
![Docker](https://img.shields.io/badge/Docker-444444?style=flat&logo=Docker)
![C++](https://img.shields.io/badge/C++-444444?style=flat&logo=c%2B%2B)



## 🧐 상황 판단 알고리즘 구현
#### Detail information in this link: [Here](https://github.com/SSU-CAR/SSU-CAR_Embeded)
Monitor the driver's forward attention by pupil, head pose and phone detection.  
Three evaluation factors - Closed eye detection, Head pose estimation, Phone detection    
<img width="600" alt="img1" src="https://github.com/SSU-CAR/SSU-CAR_Embeded/assets/107911398/3e5b8ff1-3ff0-49f1-a111-0ddbeedbca80">

Monitor the illegal lane change like changing in solid line and without direction light.  

DrivenDist - Report driving distance and current veloicity.  
Joystick_usb - Control RC car with joystick.  
LaeDetection, lane_ex - Lane detetction with HSV(HSL) filtering.  
<img width="600" alt="img1" src="https://github.com/SSU-CAR/SSU-CAR_Embeded/assets/107911398/f5f10145-ed10-4ec9-9722-8f5671cca517">


## 트러블 슈팅
### AWS 배포 과정에서 에러 (서버 다운)

#### **문제 상황** : EC2 인스턴스로 배포, codedeploy와 Github Actions로 배포 자동화해서 사용하던중 서버 갑자기 느려짐-> 다운됨

#### 원인➀ : EC2 인스턴스 재부팅 시 CodeDeploy 꺼짐
  * EC2 인스턴스에 빌드파일, 실행중인 8080 포트 없음 확인
  * `systemctl enable codedeploy-agent` : 재부팅 시 꺼지는 CodeDeploy 자동으로 켜지게 설정

#### 원인② : 인스턴스 내 MySQL 메모리 과부하
  * EC2 인스턴스에는 mysqld 필요 없는데 계속 실행하면서 메모리 과부하 발생
  * `systemctl disable mysqld` : 인스턴스 재부팅 시에도 자동으로 mysqld 안켜지게 설정
  * swap memory 로 메모리 확보
    * `sudo dd if=/dev/zero of=/swapfile bs=128M count=16`
    * `sudo chmod 600/swapfile`
    * `sudo swapon /swapfile`
    * `sudo swapon -s`
    * `sudo vi /etc/fstab` : 메모리 남은거 확인
   


## 🧾 API 명세서

| 카테고리 | 기능                  | HTTP 메서드 | URI                      | Request                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     | Response                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   |
| ---- | ------------------- | --------- | ------------------------ | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| 임베디드 | 실시간 상황 값 전달         | POST      | /driving/embedded        | {<br>”type” : 1,<br>”createdAt : “2024-02-12 09:51:16”<br>}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 | {<br>주행 중이면 HttpStatus.OK<br>주행 중 아니면 HttpStatus.ACCEPTED<br>}                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
| SSE  | 프론트엔드 SSE통신         | POST      | /driving/events          |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
| 홈    | 최근 주행 점수            | GET      | /home/score              | {<br>"score" : 60<br>}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      |
| 홈    | 최근 주행 3개 점수         | GET      | /home/latestScores       | {<br>"scores": [<br>{<br>"reportId": 1,<br>"score": 80<br>},<br>{<br>"reportId": 2,<br>"score": 70<br>},<br>{<br>"reportId": 3,<br>"score": 100<br>}<br>]<br>}                                                                                                                                                                                                                                                                                                                                                                                                                                              |
| 홈    | 최근 주행 피드백           | GET      | /home/feedback           | {<br>"feedback" : "차선 변경에 좀 더 신경써봅시다"<br>}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
| 홈    | 주의해야할 운전 습관         | GET      | /home/recentRisks        | {<br>"recentRisks": [<br>{<br>"scenarioType": 2,<br>"scenarioName": "핸드폰 사용",<br>"scenarioCount": 2<br>},<br>{<br>"scenarioType": 52,<br>"scenarioName": "실선에서 차선변경",<br>"scenarioCount": 2<br>},<br>{<br>"scenarioType": 51,<br>"scenarioName": "방향지시등 안 켜고 차선변경",<br>"scenarioCount": 1<br>}<br>]<br>}                                                                                                                                                                                                                                                                                                    |
| 홈    | 주행 시작               | POST      | /driving/start           | {<br>”reportId” : 1<br>}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
| 주행   | 주행 끝 (목적지 도착)       | PATCH     | /driving/end             | {<br>”reportId” : 1<br>}<br>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
| 주행   | 주행 끝 - 상세 내용 조회     | GET      | /driving/end/{report-id} | {<br>”reportId” : 1,<br>”departuredAt” : "2024-02-12 09:51:16",<br>”arrivedAt” : "2024-02-12 12:03:44",<br>”mileage” : 110.5,<br>"score" : 80,<br>”scoreComment” : “지난번보다 20점이나 올랐네요! 수고하셨습니다!”,<br>"internalSummaries": [<br>{<br>"scenarioType": 1,<br>"scenarioName": "졸음 운전",<br>”scenarioCount": 3<br>},<br>{<br>"scenarioType": 2,<br>"scenarioName": "차선 변경",<br>”scenarioCount": 5<br>}<br>],<br>"externalSummaries": [<br>{<br>"scenarioType": 1,<br>"scenarioName": "차선 변경",<br>”scenarioCount": 2<br>},<br>{<br>"scenarioType": 2,<br>"scenarioName": "과속",<br>”scenarioCount": 1<br>}<br>]<br>} |
| 기록   | 기록 전체 조회            | GET      | /history                 |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             | {<br>{<br>”reportId” : 1,<br>”departuredAt” : "2024-02-12 09:51:16",<br>”arrivedAt” : "2024-02-12 12:03:44",<br>”mileage” : 25.523,<br>”score” : 80<br>},<br>{<br>”reportId” : 2,<br>”departuredAt” : "2024-02-12 09:51:16",<br>”arrivedAt” : "2024-02-12 12:03:44",<br>”mileage” : 25.523,<br>”score” : 80<br>}<br>}                                                                                                                                                                                                      |
| 기록   | 기록 상세 조회            | GET      | /history/{report-id}     | {<br>"internalSummaries": [<br>{<br>"scenarioType": 1,<br>"scenarioName": "전방 주시 태만",<br>"scenarioCount": 5<br>},<br>{<br>"scenarioType": 2,<br>"scenarioName": "졸음 운전",<br>"scenarioCount": 1<br>}<br>],<br>"externalSummaries": [<br>{<br>"scenarioType": 51,<br>"scenarioName": "차선 변경",<br>"scenarioCount": 1<br>}<br>]<br>}                                                                                                                                                                                                                                                                            |
| 리포트  | (간단) 주행 이력 조회       | POST      | /feedback/bio            | {<br>”thisMonth”: 2<br>}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    | {<br>"monthlyMileage": “20.2",<br>"totalMileage": "1206.456",<br>"latestDeparture": "2023-10-23 18:51:16",<br>"latestArrival": "2023-10-23 19:30:44",<br>}                                                                                                                                                                                                                                                                                                                                                                 |
| 리포트  | 나의 안전 점수 조회         | POST      | /feedback/score          | {<br>”thisMonth”: 2<br>}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    | {<br>”averageScore” : 75.5<br>}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            |
| 리포트  | 이번달 주의 항목 - 상위 4개   | POST      | /feedback/top4           | {<br>”thisMonth”: 2<br>}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    | {<br>"topRisks": [<br>{<br>"scenarioType": 2,<br>"scenarioName": "핸드폰 사용",<br>"scenarioCount": 2<br>},<br>{<br>"scenarioType": 52,<br>"scenarioName": "실선에서 차선변경",<br>"scenarioCount": 2<br>},<br>{<br>"scenarioType": 51,<br>"scenarioName": "방향지시등 안 켜고 차선변경",<br>"scenarioCount": 1<br>},<br>{<br>"scenarioType": 3,<br>"scenarioName": "졸음 운전 (눈)",<br>"scenarioCount": 1<br>}<br>]<br>}                                                                                                                               |
| 리포트  | 이번달 주의 항목 - 내외부 나눠서 | POST      | /feedback/caution        | {<br>”thisMonth”: 2<br>}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    | {<br>"internalSummaries": [<br>{<br>"scenarioType": 2,<br>"scenarioName": "핸드폰 사용",<br>"scenarioCount": 5<br>},<br>{<br>"scenarioType": 1,<br>"scenarioName": "졸음 운전(고개)",<br>"scenarioCount": 3<br>},<br>{<br>"scenarioType": 3,<br>"scenarioName": "졸음 운전(눈)",<br>"scenarioCount": 2<br>}<br>],<br>"externalSummaries": [<br>{<br>"scenarioType": 51,<br>"scenarioName": "방향지시등 안 켜고 차선변경",<br>"scenarioCount": 5<br>},<br>{<br>"scenarioType": 52,<br>"scenarioName": "실선에서 차선변경",<br>"scenarioCount": 1<br>}<br>]<br>} |
| 뱃지   | 뱃지 전체 조회            | GET      | /badge                   |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             | {<br>{<br>"badgeId": 1,<br>"status": 0,<br>"name": "귀향길 운전왕",<br>”caption”: “시작이 반이다! 벌써 베스트 드라이버에 가까워지고 있어요.”<br>},<br>{<br>"badgeId": 2,<br>"status": 1,<br>"name": "베스트 드라이버",<br>”caption”: “시작이 반이다! 벌써 베스트 드라이버에 가까워지고 있어요.”<br>},<br>{<br>"badgeId": 3,<br>"status": 0,<br>"name": "피드백 만점",<br>”caption”: “시작이 반이다! 벌써 베스트 드라이버에 가까워지고 있어요.”<br>}<br>}                                                                                                                                                             |




