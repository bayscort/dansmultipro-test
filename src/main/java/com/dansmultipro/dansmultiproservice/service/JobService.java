package com.dansmultipro.dansmultiproservice.service;

import com.dansmultipro.dansmultiproservice.bean.JobResponseBean;
import com.dansmultipro.dansmultiproservice.service.internal.DansMultiProService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobService {

    private final DansMultiProService dansMultiProService;

    public List<JobResponseBean> getJobList() throws IOException, InterruptedException {
        return dansMultiProService.getPositionList();
    }

    public JobResponseBean getJobPositionDetail(String id) {
        return dansMultiProService.getPositionDetail(id);
    }
}
