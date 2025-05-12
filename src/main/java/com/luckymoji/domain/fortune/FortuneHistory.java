package com.luckymoji.domain.fortune;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "fortune_history")
public class FortuneHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String emojis;

    @Column(columnDefinition = "TEXT")
    private String fortune;

    private LocalDateTime createdAt;

    protected FortuneHistory() {}

    public FortuneHistory(String emojis, String fortune) {
        this.emojis = emojis;
        this.fortune = fortune;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getEmojis() {
        return emojis;
    }

    public String getFortune() {
        return fortune;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
