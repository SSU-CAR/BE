//package ssucar.config;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import ssucar.scenario.entity.Scenario;
//import ssucar.scenario.repository.ScenarioRepository;
//
//@Configuration
//public class DataInitializer {
//
//    @Bean
//    public CommandLineRunner initializeScenarioData(ScenarioRepository scenarioRepository) {
//        return args -> {
//            scenarioRepository.save(new Scenario.Builder()
//                    .name("차선 변경")
//                    .value(5)
//                    .total(0)
//                    .build());
//            scenarioRepository.save(new Scenario(null, "전방 주시 안함", 3, 0));
//        };
//    }
//
////    @Bean
////    public CommandLineRunner initializeBadgeData(BadgeRepository badgeRepository) {
////        return args -> {
////            // 배지 테이블 초기화 작업 수행
////        };
////    }
//}
