package com.dansmultipro.dansmultiproservice;

import com.dansmultipro.dansmultiproservice.bean.JobResponseBean;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class JobResponseWrapper {
    private List<JobResponseBean> data;
}
