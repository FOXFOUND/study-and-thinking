package com.searchone.searcheye.model;

import lombok.Data;

import java.util.concurrent.CopyOnWriteArrayList;

@Data
public class ResponseObject {
    private CopyOnWriteArrayList resultArrayList;
}
