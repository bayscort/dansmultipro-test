package com.dansmultipro.dansmultiproservice.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobResponseBean {
    private String id;
    private String type;
    private String url;
    private String created_at;
    private String company;
    private String company_url;
    private String location;
    private String title;
    private String description;
    private String how_to_apply;
    private String company_logo;
}
