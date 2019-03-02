package com.searchone.searcheye.controller;

import com.google.gson.Gson;
import com.searchone.searcheye.model.RequestObject;
import com.searchone.searcheye.model.ResponseObject;
import com.searchone.searcheye.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/searchEye")
public class SearchController {
    @Autowired
    private SearchService searchService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam("text") String text) {
        RequestObject requestObject = new RequestObject();
        requestObject.setText(text);
        ResponseObject responseObject = searchService.getResponseObject(requestObject);

        Gson gson = new Gson();
        System.out.println(responseObject.getResultArrayList().get(0));
        return gson.toJson(responseObject.getResultArrayList().get(0));
    }
}
