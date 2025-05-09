package com.luckymoji.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.URL;
import java.util.*;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() throws IOException {
        return "Hello, LuckyMoji!";
//        ObjectMapper mapper = new ObjectMapper();
//
//        // 원격 JSON 파일 바로 읽기
//        JsonNode root = mapper.readTree(new URL("https://raw.githubusercontent.com/github/gemoji/master/db/emoji.json"));
//        List<String> emojiList = new ArrayList<>();
//
//        for (JsonNode node : root) {
//            JsonNode emojiNode = node.get("emoji");
//            if (emojiNode != null) {
//                emojiList.add(emojiNode.asText());
//            }
//        }
//
//        // 출력 (예: Java 배열 형식으로)
//        StringBuilder sb = new StringBuilder();
//        sb.append("List<String> emojis = Arrays.asList(");
//        for (int i = 0; i < emojiList.size(); i++) {
//            sb.append("    \"").append(emojiList.get(i)).append("\"");
//            if (i < emojiList.size() - 1) sb.append(",");
//        }
//        sb.append(");");
//        return sb.toString();
    }
}
