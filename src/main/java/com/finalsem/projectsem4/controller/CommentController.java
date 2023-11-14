package com.finalsem.projectsem4.controller;

import com.finalsem.projectsem4.common.ResponseBuilder;
import com.finalsem.projectsem4.dto.CommentsDTO;
import com.finalsem.projectsem4.entity.Comments;
import com.finalsem.projectsem4.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ly Quoc Trong
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService service;

    public CommentController(CommentService service) {
        this.service = service;
    }

    @GetMapping("/all")
    ResponseEntity<?> getAllComments() {
        ResponseBuilder<List<CommentsDTO>> resp = service.getAllComment();
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PostMapping("/add")
    ResponseEntity<?> addComment(@RequestBody CommentsDTO dto) {
        ResponseBuilder<CommentsDTO> resp = service.createComment(dto);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<?> updateComment(@PathVariable Long id, @RequestBody CommentsDTO dto) {
        ResponseBuilder<CommentsDTO> resp = service.updateComment(id, dto);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteComment(@PathVariable Long id) {
        ResponseBuilder resp = service.deleteComment(id);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    ResponseEntity<?> getCommentById(@PathVariable Long id) {
        ResponseBuilder<CommentsDTO> resp = service.getCommentById(id);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/get/user/{id}")
    ResponseEntity<?> getCommentByUserId(@PathVariable Long id) {
        ResponseBuilder<List<CommentsDTO>> resp = service.getCommentByUserId(id);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/get/product/{id}")
    ResponseEntity<?> getCommentByProductId(@PathVariable Long id) {
        ResponseBuilder<List<CommentsDTO>> resp = service.getCommentByProductId(id);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/get/user/{userId}/product/{productId}")
    ResponseEntity<?> getCommentByUserIdAndProductId(@PathVariable Long userId, @PathVariable Long productId) {
        ResponseBuilder<List<CommentsDTO>> resp = service.getCommentByUserIdAndProductId(userId, productId);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
