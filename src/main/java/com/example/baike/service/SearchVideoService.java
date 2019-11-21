package com.example.baike.service;

import com.example.baike.model.BKInteractiveVideo;

public interface SearchVideoService {
    BKInteractiveVideo selectByName(String SearchName);
}
