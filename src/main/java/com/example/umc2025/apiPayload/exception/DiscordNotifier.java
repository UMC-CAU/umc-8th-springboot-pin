package com.example.umc2025.apiPayload.exception;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;

public class DiscordNotifier {

    private static final String WEBHOOK_URL = "https://discord.com/api/webhooks/1371399671888482314/ZXcKERBJTy-OeXqBGUWvF18trZO8YYN1tRa1NXK3BxsGWZREykOsxaNS8A4hKojUojgu";


    public static void sendErrorLog(String url, String message, Exception e) {
        String payload = buildJsonPayload(url, message, e);

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(WEBHOOK_URL))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(payload))
                    .build();

            client.sendAsync(request, HttpResponse.BodyHandlers.discarding());
        } catch (Exception ex) {
            System.out.println("디스코드 전송 실패: " + ex.getMessage());
        }
    }

    private static String buildJsonPayload(String url, String message, Exception e) {
        return """
        {
            "embeds": [{
                "title": "🚨 500 에러 발생",
                "color": 15158332,
                "fields": [
                    { "name": "요청 URL", "value": "%s" },
                    { "name": "에러 메시지", "value": "%s" },
                    { "name": "시각", "value": "%s" }
                ]
            }]
        }
        """.formatted(url, message, LocalDateTime.now());
    }
}
