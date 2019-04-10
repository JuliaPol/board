package com.board.service.impl;

import com.board.service.LinkGenerationService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LinkGenerationServiceImpl implements LinkGenerationService {

    //TODO: this method should be more security
    @Override
    public String getLinkForNewBoard(String parent, String child) {
        return parent + child;
    }
}
