package io.crud.crud.model;

import org.springframework.data.annotation.Id;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public class Post {
    @Id
    public String id;
    public String title;
    public String content;
    public String authorId;
    public int views = 0;
}
