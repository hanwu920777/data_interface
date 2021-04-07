package com.sumscope.data.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonRootBean {

    private int code;
    private String message;
    private int startPage;
    private int pageSize;
    private List<ResultBean> resultTable;

}