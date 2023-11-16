package com.finalsem.projectsem4.mapper;

import com.finalsem.projectsem4.dto.ProductFEDTO;
import com.finalsem.projectsem4.dto.SizeFEDTO;
import com.finalsem.projectsem4.dto.VariationFEDTO;
import com.finalsem.projectsem4.entity.ProductFE;
import com.finalsem.projectsem4.entity.SizeFE;
import com.finalsem.projectsem4.entity.VariationFE;

import java.util.List;
import java.util.stream.Collectors;

public class EntityToDTOMapper {

    public static SizeFEDTO mapSizeToDTO(SizeFE size) {
        return new SizeFEDTO(size.getName(), size.getStock());
    }

    public static VariationFEDTO mapVariationToDTO(VariationFE variation) {
        List<SizeFEDTO> sizeDTOs = variation.getSizes()
                .stream()
                .map(EntityToDTOMapper::mapSizeToDTO)
                .collect(Collectors.toList());

        return new VariationFEDTO(variation.getColor(), variation.getColorCode(), variation.getImage(), sizeDTOs);
    }
}
