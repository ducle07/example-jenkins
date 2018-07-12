package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String topicId) {
        List<Course> course = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(course::add);
        return course;
    }

    public Course getCourse(String id) {
        //return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
        return courseRepository.findById(id).get();
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
		/*for(int i=0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}*/
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        //topics.removeIf(topic -> topic.getId().equals(id));
        courseRepository.deleteById(id);
    }
}
