package org.example;

import org.example.config.ProjectConfig;
import org.example.model.Comment;
import org.example.proxies.EmailCommentNotificationProxy;
import org.example.repositories.DBCommentRepository;
import org.example.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {
    public static void main( String[] args ) {
        var commentRepository = new DBCommentRepository();
        var commentNotificationProxy = new EmailCommentNotificationProxy();
        var commentService = new CommentService(commentRepository, commentNotificationProxy);

        var comment = new Comment();
        comment.setAuthor("John Doe");
        comment.setText("Hello World");

        commentService.publishComment(comment);
    }
}