package org.example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.config.ProjectConfig;
import org.example.model.Comment;
import org.example.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {
    private static final Log log = LogFactory.getLog(App.class);

    public static void main(String[] args ) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var service = context.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setText("Demo comment");
        comment.setAuthor("Natasha");

        service.publishComment(comment);
        service.deleteComment(comment);
        service.editComment(comment);
    }
}