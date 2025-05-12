package com.luckymoji.repository;

import com.luckymoji.domain.fortune.FortuneHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FortuneHistoryRepository extends JpaRepository<FortuneHistory, Long> {
}
