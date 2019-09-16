package com.api.challenge.invoicesynchronizer.service;

import com.api.challenge.invoicesynchronizer.client.ArquiveiClient;
import com.api.challenge.invoicesynchronizer.client.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ArquiveiServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private ArquiveiClient client;

    @Before
    public void init() {
        ReflectionTestUtils.setField(client, "url", "http://teste");
    }

    @Test
    public void shouldReturnResponse() {

        Response response = new Response();

        Mockito
            .when(restTemplate.exchange(anyString(),
                    any(HttpMethod.class),
                    any(HttpEntity.class),
                    any(ParameterizedTypeReference.class)))
            .thenReturn(new ResponseEntity<>(response, HttpStatus.OK) );

        client.extractDataFromAPI(0L);

        Mockito.verify(restTemplate, Mockito.times(1)).exchange(anyString(),
                any(HttpMethod.class),
                any(HttpEntity.class),
                any(ParameterizedTypeReference.class));
    }



}

