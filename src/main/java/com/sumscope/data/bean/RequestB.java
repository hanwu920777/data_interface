package com.sumscope.data.bean;

import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class RequestB {
    private int page;
    private String date;
    private String sdnCode;

    }

