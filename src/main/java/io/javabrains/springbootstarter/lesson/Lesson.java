package io.javabrains.springbootstarter.lesson;

import io.javabrains.springbootstarter.course.Course;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(collection="lesson")
public class Lesson {

    @Id
    private String id;
    @NotNull
    private String name;
    private String description;

    private Course course;

    public Lesson() {

    }

    public Lesson(String id, String name, String description, String topicId, String courseId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.course = new Course(courseId, "", "", topicId);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
