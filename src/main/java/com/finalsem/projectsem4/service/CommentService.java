package com.finalsem.projectsem4.service;

import com.finalsem.projectsem4.common.ResponseBuilder;
import com.finalsem.projectsem4.dto.CommentsDTO;

import java.util.List;

/**
 * @author Ly Quoc Trong
 */
public interface CommentService {
    ResponseBuilder<List<CommentsDTO>> getAllComment();

    ResponseBuilder<CommentsDTO> getCommentById(Long id);

    ResponseBuilder<CommentsDTO> createComment(CommentsDTO dto);

    ResponseBuilder<CommentsDTO> updateComment(Long id, CommentsDTO dto);

    ResponseBuilder deleteComment(Long id);

    ResponseBuilder<List<CommentsDTO>> getCommentByUserId(Long id);

    ResponseBuilder<List<CommentsDTO>> getCommentByProductId(Long id);

    ResponseBuilder<List<CommentsDTO>> getCommentByUserIdAndProductId(Long userId, Long productId);
}
