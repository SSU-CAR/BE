package ssucar.badge.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssucar.badge.entity.Badge;
import ssucar.badge.repository.BadgeRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BadgeService {

    @Autowired
    private final BadgeRepository badgeRepository;

    @Transactional
    public List<Badge> getBadges() {
        List<Badge> list = badgeRepository.findAll();
        return list;
    }

    @Transactional
    public void updateBadge(int badgeId) {
        Badge badge = badgeRepository.findById(badgeId).orElseThrow(() -> new IllegalArgumentException(("해당 번호의 배지가 존재하지 않습니다.")));
        int number = badge.getNumber();
        badge.setNumber(++number);
        if(badge.getNumber() == badge.getGoal())
            badge.setStatus(1);
        badgeRepository.save(badge);
    }
}
