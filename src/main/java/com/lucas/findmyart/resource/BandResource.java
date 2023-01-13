package com.lucas.findmyart.resource;

import com.lucas.findmyart.service.BandService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/0.0.1/bands")
@AllArgsConstructor
public class BandResource {

    private BandService bandService;

}
