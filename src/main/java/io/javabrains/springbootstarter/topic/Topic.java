package io.javabrains.springbootstarter.topic;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "topic")
public class Topic {

    @ApiModelProperty(notes = "The topic's ID", required=true)
    @Id
    private String id;
    @ApiModelProperty(notes = "The topic's name", required=true)
    private String name;
    @ApiModelProperty(notes = "The topic's description")
    private String description;

    public Topic() {

    }

    public Topic(String id, String name, String description) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
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

}
