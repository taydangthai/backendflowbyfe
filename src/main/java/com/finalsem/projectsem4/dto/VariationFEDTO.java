package com.finalsem.projectsem4.dto;

import com.finalsem.projectsem4.entity.SizeFE;
import lombok.Data;
import java.util.List;

@Data
public class VariationFEDTO {

    private Long id;
    private String color;
    private String colorCode;
    private String image;
    private List<SizeFEDTO> size;

    public VariationFEDTO(String color, String colorCode, String image, List<SizeFEDTO> size) {
        this.color = color;
        this.colorCode = colorCode;
        this.image = image;
        this.size = size;
    }
}
