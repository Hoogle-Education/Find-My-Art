package com.lucas.findmyart.service;

import com.lucas.findmyart.repository.BandRepository;
import com.lucas.findmyart.repository.PubRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PubService {

    private PubRepository pubRepository;
    private BandRepository bandRepository;

}
