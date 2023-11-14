package com.finalsem.projectsem4.repository;

import com.finalsem.projectsem4.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ly Quoc Trong
 */
@Repository
public interface CommentRepository extends JpaRepository<Comments, Long> {
    List<Comments> getCommentsByUsersId(Long userId);

    List<Comments> getCommentsByProductsId(Long productId);

    List<Comments> getCommentsByUsersIdAndProductsId(Long userId, Long productId);
}
