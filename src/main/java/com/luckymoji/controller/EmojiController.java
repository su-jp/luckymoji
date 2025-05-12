package com.luckymoji.controller;

import com.luckymoji.service.EmojiService;
import com.luckymoji.service.FortuneHistoryService;
import com.luckymoji.service.OpenAIService;
import com.luckymoji.util.PromptBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class EmojiController {

    private final EmojiService emojiService;
    private final OpenAIService openAIService;
    private final FortuneHistoryService fortuneHistoryService;

    public EmojiController(EmojiService emojiService, OpenAIService openAIService, FortuneHistoryService fortuneHistoryService) {
        this.emojiService = emojiService;
        this.openAIService = openAIService;
        this.fortuneHistoryService = fortuneHistoryService;
    }

    @GetMapping("/api/random-emojis")
    public Map<String, Object> getRandomEmojis() {
        List<String> randomEmojis = emojiService.getRandomEmojis(3);
        String fortune = openAIService.getFortuneFromGPT(
                PromptBuilder.getSystemPrompt(),
                PromptBuilder.buildUserPrompt(randomEmojis)
        );

        // 운세 저장
        fortuneHistoryService.save(String.join("", randomEmojis), fortune);

        return Map.of(
                "emojis", randomEmojis,
                "fortune", fortune
        );
    }
}