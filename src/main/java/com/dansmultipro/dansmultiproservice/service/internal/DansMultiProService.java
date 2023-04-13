package com.dansmultipro.dansmultiproservice.service.internal;

import com.dansmultipro.dansmultiproservice.bean.JobResponseBean;
import com.dansmultipro.dansmultiproservice.constant.Constants;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DansMultiProService {
    private final Gson gson = new GsonBuilder().disableHtmlEscaping().serializeNulls().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();

    @Value("${services.dansmultipro.url}")
    private String DANSMULTIPRO_URL;
    @Value("${services.dansmultipro-positions.url}")
    private String DANSMULTIPRO_POSITIONS_URL;
    @Value("${services.dansmultipro-positions-detail.url}")
    private String DANSMULTIPRO_POSITIONS_DETAIL_URL;

    private static final HttpClient HTTP_CLIENT = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    public List<JobResponseBean> getPositionList() throws IOException, InterruptedException {

        URI url = URI.create(DANSMULTIPRO_URL + DANSMULTIPRO_POSITIONS_URL);
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(url)
                .header(Constants.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
        HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        return gson.fromJson(response.body(), ArrayList.class);

    }

    public JobResponseBean getPositionDetail(String id) {
        return WebClient.create(DANSMULTIPRO_URL)
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(DANSMULTIPRO_POSITIONS_DETAIL_URL)
                        .build(id))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<JobResponseBean>() {
                })
                .doOnError(throwable -> {
                    log.debug("Error while get position detail"+ throwable);
                })
                .block();
    }
}
