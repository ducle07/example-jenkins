package io.javabrains.springbootstarter.course;

import io.javabrains.springbootstarter.topic.Topic;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="course")
public class Course {

    @ApiModelProperty(notes = "The topic's ID", required=true)
    @Id
    private String id;
    @ApiModelProperty(notes = "The topic's name", required=true)
    private String name;
    @ApiModelProperty(notes = "The topic's description")
    private String description;


    private Topic topic;

    public Course() {

    }

    public Course(String id, String name, String description, String topicId) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.topic = new Topic(topicId, "", "");
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

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

}
