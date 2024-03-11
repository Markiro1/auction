package com.ashapiro.auction.controller;

import com.ashapiro.auction.dto.contactUs.ContactUsDto;
import com.ashapiro.auction.service.ContactUsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact-us")
@RequiredArgsConstructor
public class ContactUsController {

    private final ContactUsService contactUsService;

    @PostMapping("/save")
    public void save(@RequestBody ContactUsDto contactUsDto) {
        contactUsService.save(contactUsDto);
    }
}
