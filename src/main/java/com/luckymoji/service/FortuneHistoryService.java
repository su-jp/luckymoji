package com.luckymoji.service;

import com.luckymoji.domain.fortune.FortuneHistory;
import com.luckymoji.repository.FortuneHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FortuneHistoryService {

    private final FortuneHistoryRepository fortuneHistoryRepository;

    public void save(String emojis, String fortune) {
        FortuneHistory fortuneHistory = new FortuneHistory(emojis, fortune);
        fortuneHistoryRepository.save(fortuneHistory);
    }
}
