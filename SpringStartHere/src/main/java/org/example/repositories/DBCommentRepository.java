package org.example.repositories;

import org.example.model.Comment;
import org.springframework.stereotype.Repository;

@Repository /* Just for design porposes, this stereotype annotation does the same as the @Component stereotype annotation.
We use @Repository to define this object as a component with the responsibility of the repository.*/
public class DBCommentRepository implements CommentRepository {

    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing comment " + comment.getText());
    }
}