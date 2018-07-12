package io.javabrains.springbootstarter.lesson;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LessonRepository extends MongoRepository<Lesson, String> {

    public List<Lesson> findByCourseId(String courseId);

}
