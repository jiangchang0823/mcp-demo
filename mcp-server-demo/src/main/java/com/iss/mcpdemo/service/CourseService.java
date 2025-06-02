package com.iss.mcpdemo.service;

import com.iss.mcpdemo.record.Course;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CourseService implements IMcpProviderService {

    @Tool(name = "getAllCourses", description = "Get all courses")
    public List<Course> getAll() {

        return new ArrayList<>(List.of(
                new Course("1", "Course 1", "Description 1"),
                new Course("2", "Course 2", "Description 2"),
                new Course("3", "Course 3", "Description 3")
        ));
    }

}
