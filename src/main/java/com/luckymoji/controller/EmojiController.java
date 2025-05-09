package com.luckymoji.controller;

import com.luckymoji.service.EmojiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmojiController {

    private final EmojiService emojiService;

    public EmojiController(EmojiService emojiService) {
        this.emojiService = emojiService;
    }

    @GetMapping("/api/random-emojis")
    public Map<String, Object> getRandomEmojis() {
        List<String> randomEmojis = emojiService.getRandomEmojis(3);
        Map<String, Object> response = new HashMap<>();
        response.put("emojis", randomEmojis);
        return response;
    }
}