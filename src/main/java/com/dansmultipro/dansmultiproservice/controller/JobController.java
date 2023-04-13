package com.dansmultipro.dansmultiproservice.controller;

import com.dansmultipro.dansmultiproservice.bean.GeneralWrapper;
import com.dansmultipro.dansmultiproservice.constant.Constants;
import com.dansmultipro.dansmultiproservice.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(Constants.SERVICE_API)
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @GetMapping("/job/list")
    public GeneralWrapper<?> getJobList() throws IOException, InterruptedException {
        return new GeneralWrapper<>().success(jobService.getJobList());
    }

    @GetMapping("/job/detail/{id}")
    public GeneralWrapper<?> getJobDetail(@PathVariable String id) {
        return new GeneralWrapper<>().success(jobService.getJobPositionDetail(id));
    }

}
