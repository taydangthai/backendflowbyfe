package com.finalsem.projectsem4.service.impl;

import com.finalsem.projectsem4.common.DateTimeUtil;
import com.finalsem.projectsem4.common.ResponseBuilder;
import com.finalsem.projectsem4.dto.RatingsDTO;
import com.finalsem.projectsem4.entity.Rating;
import com.finalsem.projectsem4.repository.ProductRepository;
import com.finalsem.projectsem4.repository.RatingRepository;
import com.finalsem.projectsem4.repository.UsersRepository;
import com.finalsem.projectsem4.service.RatingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ly Quoc Trong
 */
@Service
public class RatingServiceImpl implements RatingService {

    private final UsersRepository usersRepository;

    private final ProductRepository productRepository;
    private final RatingRepository ratingRepository;

    public RatingServiceImpl(RatingRepository ratingRepository, UsersRepository usersRepository, ProductRepository productRepository) {
        this.ratingRepository = ratingRepository;
        this.usersRepository = usersRepository;
        this.productRepository = productRepository;
    }

    @Override
    public ResponseBuilder<List<RatingsDTO>> getRatingByProductId(Long id) {
        List<Rating> ratings = ratingRepository.getRatingByProductsId(id);
        List<RatingsDTO> ratingsDTOList = ratings.stream().map(rating -> {
            RatingsDTO ratingsDTO;
            ModelMapper modelMapper = new ModelMapper();
            ratingsDTO = modelMapper.map(rating, RatingsDTO.class);
            ratingsDTO.setCreatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, rating.getCreatedAt()));
            ratingsDTO.setUpdatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, rating.getUpdatedAt()));
            return ratingsDTO;
        }).collect(Collectors.toList());
        return new ResponseBuilder<>("00", "Success", ratingsDTOList);
    }

    @Override
    public ResponseBuilder<RatingsDTO> addRating(RatingsDTO dto) {
        try {
            Rating rating = new Rating();
            ModelMapper modelMapper = new ModelMapper();
            rating = modelMapper.map(dto, Rating.class);
            rating.setUsers(usersRepository.getReferenceById(dto.getUserId()));
            rating.setProducts(productRepository.getReferenceById(dto.getProductId()));
            ratingRepository.save(rating);
            return new ResponseBuilder<>("00", "Success", dto);
        } catch (Exception e) {
            return new ResponseBuilder<>("99", "Error");
        }
    }

    @Override
    public ResponseBuilder<RatingsDTO> updateRating(RatingsDTO dto) {
        try {
            Rating rating = ratingRepository.getReferenceById(dto.getId());
            ModelMapper modelMapper = new ModelMapper();
            rating = modelMapper.map(dto, Rating.class);
            rating.setUsers(usersRepository.getReferenceById(dto.getUserId()));
            rating.setProducts(productRepository.getReferenceById(dto.getProductId()));
            ratingRepository.save(rating);
            return new ResponseBuilder<>("00", "Success", dto);
        } catch (Exception e) {
            return new ResponseBuilder<>("99", "Error");
        }
    }

    @Override
    public ResponseBuilder deleteRating(Long id) {
        try {
            ratingRepository.deleteById(id);
            return new ResponseBuilder<>("00", "Success");
        } catch (Exception e) {
            return new ResponseBuilder<>("99", "Error");
        }
    }

    @Override
    public ResponseBuilder<RatingsDTO> getRatingById(Long id) {
        Rating rating = ratingRepository.getReferenceById(id);
        RatingsDTO ratingsDTO;
        ModelMapper modelMapper = new ModelMapper();
        ratingsDTO = modelMapper.map(rating, RatingsDTO.class);
        ratingsDTO.setCreatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, rating.getCreatedAt()));
        ratingsDTO.setUpdatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, rating.getUpdatedAt()));
        return new ResponseBuilder<>("00", "Success", ratingsDTO);
    }

    @Override
    public ResponseBuilder<List<RatingsDTO>> getRatingByUserId(Long id) {
        List<Rating> ratings = ratingRepository.getRatingByUsersId(id);
        List<RatingsDTO> ratingsDTOList = ratings.stream().map(rating -> {
            RatingsDTO ratingsDTO;
            ModelMapper modelMapper = new ModelMapper();
            ratingsDTO = modelMapper.map(rating, RatingsDTO.class);
            ratingsDTO.setCreatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, rating.getCreatedAt()));
            ratingsDTO.setUpdatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, rating.getUpdatedAt()));
            return ratingsDTO;
        }).collect(Collectors.toList());
        return new ResponseBuilder<>("00", "Success", ratingsDTOList);
    }

    @Override
    public ResponseBuilder<List<RatingsDTO>> getRatingByUserIdAndProductId(Long userId, Long productId) {
        List<Rating> ratings = ratingRepository.getRatingByUsersIdAndProductsId(userId, productId);
        List<RatingsDTO> ratingsDTOList = ratings.stream().map(rating -> {
            RatingsDTO ratingsDTO;
            ModelMapper modelMapper = new ModelMapper();
            ratingsDTO = modelMapper.map(rating, RatingsDTO.class);
            ratingsDTO.setCreatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, rating.getCreatedAt()));
            ratingsDTO.setUpdatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, rating.getUpdatedAt()));
            return ratingsDTO;
        }).collect(Collectors.toList());
        return new ResponseBuilder<>("00", "Success", ratingsDTOList);
    }
}
