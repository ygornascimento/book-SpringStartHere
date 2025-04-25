package org.example.services;

import org.example.model.Comment;
import org.example.proxies.CommentNotificationProxy;
import org.example.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service /* Just for design purposes, this stereotype annotation does the same as the @Component stereotype annotation.
We use @Service to define this object as a component with the responsibility of service.*/
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    /*
    We would have to use @Autowired if the class had more than one constructor.
    Spring uses this constructor to create the bean and injects references from its Context in the parameters when
    creating the instance.
    */
    public CommentService(CommentRepository commentRepository, //
                          @Qualifier("EMAIL") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
