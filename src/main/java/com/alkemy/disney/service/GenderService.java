package com.alkemy.disney.service;

import com.alkemy.disney.dto.GenderDTO;

import java.util.List;

public interface GenderService {

    GenderDTO addGender(GenderDTO dto);
    List<GenderDTO> getAllGenders();
    void deleteGender(Long id);
    GenderDTO updateGender(Long id, GenderDTO gender);
}