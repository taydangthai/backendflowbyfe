package com.finalsem.projectsem4.service;

import com.finalsem.projectsem4.common.ResponseBuilder;
import com.finalsem.projectsem4.dto.ProductFEDTO;

import java.util.List;

public interface ProductFEService {

    ResponseBuilder<List<ProductFEDTO>> getListProduct();
}
