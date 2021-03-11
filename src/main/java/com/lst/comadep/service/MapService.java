package com.lst.comadep.service;

import com.lst.comadep.Entity.ApiResponse;

public interface MapService {
    ApiResponse getMap();
    ApiResponse getAccessFrequencyLocal();
    ApiResponse getAccessFrequencyOot();
    ApiResponse InOutFrequencyByLocal(int month);
}
