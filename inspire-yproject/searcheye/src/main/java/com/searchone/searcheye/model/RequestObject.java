package com.searchone.searcheye.model;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class RequestObject {
    private String text;
    private Set<String> ketWordsSet;
    private Set<String> searchKeyWordsSet;
    private List<String> requestUrlList;
}
