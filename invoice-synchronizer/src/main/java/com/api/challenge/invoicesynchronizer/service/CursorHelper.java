package com.api.challenge.invoicesynchronizer.service;

import com.api.challenge.invoicesynchronizer.client.response.Page;
import com.api.challenge.invoicesynchronizer.client.response.Response;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CursorHelper {
    public static Long extractCursor(Page page) {
        if (page == null || page.getNext() == null) {
            throw new RuntimeException("Page not found when extracting cursos");
        } else {
            String queryParams = page.getNext().getQuery();
            if (queryParams != null && queryParams.contains("cursor")) {
                final Matcher matcher = Pattern.compile("cursor=[0-9]+").matcher(queryParams);
                if (matcher.find()) {
                    final String[] split = matcher.group(0).split("=");
                    return Long.valueOf(split[1]);
                }
            }
            throw new RuntimeException("Page not found when extracting cursor");
        }
    }
}
