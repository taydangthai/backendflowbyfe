package com.finalsem.projectsem4.service;

import com.finalsem.projectsem4.common.ResponseBuilder;
import com.finalsem.projectsem4.dto.RatingsDTO;

import java.util.List;

/**
 * @author Ly Quoc Trong
 */
public interface RatingService {
    ResponseBuilder<List<RatingsDTO>> getRatingByProductId(Long id);

    ResponseBuilder<RatingsDTO> addRating(RatingsDTO dto);

    ResponseBuilder<RatingsDTO> updateRating(RatingsDTO dto);

    ResponseBuilder deleteRating(Long id);

    ResponseBuilder<RatingsDTO> getRatingById(Long id);

    ResponseBuilder<List<RatingsDTO>> getRatingByUserId(Long id);

    ResponseBuilder<List<RatingsDTO>> getRatingByUserIdAndProductId(Long userId, Long productId);
}
