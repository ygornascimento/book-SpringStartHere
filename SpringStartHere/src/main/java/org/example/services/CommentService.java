package org.example.services;

import org.example.model.Comment;
import org.springframework.stereotype.Service;
import java.util.logging.Logger;

@Service /* Just for design purposes, this stereotype annotation does the same as the @Component stereotype annotation.
We use @Service to define this object as a component with the responsibility of service.*/
public class CommentService {
    private Logger log = Logger.getLogger(CommentService.class.getName());

    public String publishComment(Comment comment) {
        log.info("Publishing comment: " + comment.getText());
        return "SUCCESS";
    }
}
