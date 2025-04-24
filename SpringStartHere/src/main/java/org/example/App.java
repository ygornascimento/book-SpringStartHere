package org.example;

import org.example.config.ProjectConfig;
import org.example.model.Comment;
import org.example.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {
    public static void main( String[] args ) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var commentService = context.getBean(CommentService.class);

        var comment = new Comment();
        comment.setAuthor("John Doe");
        comment.setText("Hello World Comment Text");

        commentService.publishComment(comment);
    }
}