package com.example.baike.service;

import com.example.baike.model.BKSearchUserByAdministrationViewModel;

public interface SearchUserByAdministrationService {
    BKSearchUserByAdministrationViewModel selectByName(String SearchName, Integer page,String SearchStyle,String tag);
}

