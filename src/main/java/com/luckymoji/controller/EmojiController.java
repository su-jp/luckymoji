package com.luckymoji.controller;

import com.luckymoji.service.EmojiService;
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

    public EmojiController(EmojiService emojiService, OpenAIService openAIService) {
        this.emojiService = emojiService;
        this.openAIService = openAIService;
    }

    @GetMapping("/api/random-emojis")
    public Map<String, Object> getRandomEmojis() {
        List<String> randomEmojis = emojiService.getRandomEmojis(3);
        String fortune = openAIService.getFortuneFromGPT(
                PromptBuilder.getSystemPrompt(),
                PromptBuilder.buildUserPrompt(randomEmojis)
        );

        return Map.of(
                "emojis", randomEmojis,
                "fortune", fortune
        );
    }
}