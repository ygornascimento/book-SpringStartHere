package org.example.services;

import org.example.aspects.ToLog;
import org.example.model.Comment;
import org.springframework.stereotype.Service;
import java.util.logging.Logger;

@Service /* Just for design purposes, this stereotype annotation does the same as the @Component stereotype annotation.
We use @Service to define this object as a component with the responsibility of service.*/
public class CommentService {
    private Logger log = Logger.getLogger(CommentService.class.getName());

    public void publishComment(Comment comment) {
        log.info("Publishing comment: " + comment.getText());
    }

    @ToLog
    public void deleteComment(Comment comment) {
        log.info("Deleting comment: " + comment.getText());
    }

    public void editComment(Comment comment) {
        log.info("Editing comment: " + comment.getText());
    }
}
