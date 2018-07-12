package io.javabrains.springbootstarter.lesson;

import java.util.List;

import io.javabrains.springbootstarter.course.Course;
import io.javabrains.springbootstarter.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value="topics", description="Operations to works with Dummy Topics")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @Autowired
    private CourseService courseService;

    @ApiOperation(value="View a list of topics", response=List.class)
    @ApiResponses(value= {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "Your are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(method = RequestMethod.GET, value = "/topics/{topicId}/courses/{courseId}/lessons")
    public List<Lesson> getAllLessons(@PathVariable String courseId) {
        return lessonService.getAllLessons(courseId);
    }

    @ApiOperation(value="View a topic with an ID", response=Lesson.class)
    @RequestMapping(method = RequestMethod.GET, value = "/topics/{topicId}/courses/{courseId}/lessons/{id}")
    public Lesson getLesson(@PathVariable String id) {
        return lessonService.getLesson(id);
    }

    @ApiOperation(value="Create a new topic")
    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses/{courseId}/lessons")
    public void addLesson(@RequestBody Lesson lesson, @PathVariable String courseId) {
        lesson.setCourse(courseService.getCourse(courseId));
        lessonService.addLesson(lesson);
    }

    @ApiOperation(value="Update an existing topic")
    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{courseId}/lessons/{id}")
    public void updateCourse(@RequestBody Lesson lesson, @PathVariable String courseId) {
        lesson.setCourse(courseService.getCourse(courseId));
        lessonService.updateLesson(lesson);
    }

    @ApiOperation(value="Delete a topic")
    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{courseId}/lessons/{id}")
    public void deleteLesson(@PathVariable String id) {
        lessonService.deleteLesson(id);
    }
}
