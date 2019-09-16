package com.api.challenge.invoicesynchronizer.service;

import com.api.challenge.invoicesynchronizer.client.ArquiveiClient;
import com.api.challenge.invoicesynchronizer.client.response.Response;
import org.springframework.stereotype.Service;

@Service
public class ArquiveiService {

    private ArquiveiClient arquiveiClient;

    public ArquiveiService(ArquiveiClient arquiveiClient) {
        this.arquiveiClient = arquiveiClient;
    }

    public Response readFromAPI(Long cursor) {
        return arquiveiClient.extractDataFromAPI(cursor);
    }
}
