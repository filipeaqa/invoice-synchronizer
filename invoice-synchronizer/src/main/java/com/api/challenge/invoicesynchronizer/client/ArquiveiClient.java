package com.api.challenge.invoicesynchronizer.client;

import com.api.challenge.invoicesynchronizer.client.response.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class ArquiveiClient {

    private RestTemplate restTemplate;
    private String xApiId;
    private String xApiKey;
    private String url;
    private Integer limit;

    public ArquiveiClient(RestTemplate restTemplate,
                          @Value("${arquivei.api.x-api-id}") String xApiId,
                          @Value("${arquivei.api.x-api-key}") String xApiKey,
                          @Value("${arquivei.api.limit}") Integer limit,
                          @Value("${arquivei.api.url}") String url) {
        this.restTemplate = restTemplate;
        this.xApiId = xApiId;
        this.xApiKey = xApiKey;
        this.limit = limit;
        this.url = url;
    }

    public Response extractDataFromAPI(Long cursor) {
        ResponseEntity<Response> invoiceResponse = restTemplate.exchange(
                createURI(cursor),
                HttpMethod.GET,
                createHttpEntity(),
                new ParameterizedTypeReference<Response>() {
                });

        return invoiceResponse.getBody();
    }

    private String createURI(Long cursor) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("cursor", cursor)
                .queryParam("limit", limit);
        return uriComponentsBuilder.toUriString();
    }

    private HttpEntity createHttpEntity() {
        return new HttpEntity(createHeaders());
    }

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-api-id", xApiId);
        headers.set("x-api-key", xApiKey);

        return headers;
    }
}
