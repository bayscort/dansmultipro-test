package com.dansmultipro.dansmultiproservice.service.internal;

import com.dansmultipro.dansmultiproservice.JobResponseWrapper;
import com.dansmultipro.dansmultiproservice.bean.JobResponseBean;
import com.dansmultipro.dansmultiproservice.constant.Constants;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

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

}
