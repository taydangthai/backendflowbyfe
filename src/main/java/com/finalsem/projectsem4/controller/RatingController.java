package com.finalsem.projectsem4.controller;

import com.finalsem.projectsem4.common.ResponseBuilder;
import com.finalsem.projectsem4.dto.RatingsDTO;
import com.finalsem.projectsem4.service.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ly Quoc Trong
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/rating")
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping("/product/{id}")
    ResponseEntity<?> getRatingByProductId(@PathVariable Long id) {
        ResponseBuilder<List<RatingsDTO>> resp = ratingService.getRatingByProductId(id);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    ResponseEntity<?> getRatingByUserId(@PathVariable Long id) {
        ResponseBuilder<List<RatingsDTO>> resp = ratingService.getRatingByUserId(id);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/product/{productId}")
    ResponseEntity<?> getRatingByUserIdAndProductId(@PathVariable Long userId, @PathVariable Long productId) {
        ResponseBuilder<List<RatingsDTO>> resp = ratingService.getRatingByUserIdAndProductId(userId, productId);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PostMapping("/add")
    ResponseEntity<?> addRating(@RequestBody RatingsDTO ratingsDTO) {
        ResponseBuilder<RatingsDTO> resp = ratingService.addRating(ratingsDTO);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PutMapping("/update")
    ResponseEntity<?> updateRating(@RequestBody RatingsDTO ratingsDTO) {
        ResponseBuilder<RatingsDTO> resp = ratingService.updateRating(ratingsDTO);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
