package com.luckymoji.util;

import java.util.List;

public class PromptBuilder {

    private static final String SYSTEM_PROMPT = """
            사용자가 이모지 3개를 제공하면, 오늘의 운세를 긍정적으로 해석해 "이모지 의미를 자연스럽게 포함한 하나의 문장"으로 출력하되, 추가 설명 없이 결과만 출력하세요. 제공 예시: 🍀✨🐾 -> 응답 예시: 🍀운도 좋고 ✨아이디어도 잘 떠오르니 🐾차분하게 진행하면 좋은 결과가 따르는 날
            """;

    public static String getSystemPrompt() {
        return SYSTEM_PROMPT;
    }

    public static String buildUserPrompt(List<String> emojis) {
        return "이모지: " + String.join(" ", emojis);
    }
}
