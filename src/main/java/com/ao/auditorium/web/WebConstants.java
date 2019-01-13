package com.ao.auditorium.web;

public interface WebConstants {
    public interface Pages {
        public static final String PAGES = "pages/";
        public static final String HOME = PAGES + "home";
        public static final String MY_LECTURING_FOLDER = PAGES + "my/lecturing/";
        public static final String MY_COURSES_FOLDER = PAGES + "my/courses/";
        public static final String APPLYING_TO_COURSE = PAGES + "apply-to-course";
        public static final String ALL_COURSES = PAGES + "allCourses";
        public static final String COURSE = PAGES + "course";
        public static final String MY_COURSES = PAGES + "my/myCourses";
        public static final String COURSE_LECTURES = MY_LECTURING_FOLDER + "courseLectures";
        public static final String COURSE_STUDENTS = MY_LECTURING_FOLDER + "courseStudents";
    }
    public interface Fragments {
        public static final String FRAGMENTS = "fragments/";
        public static final String HEADER = FRAGMENTS + "/header";
    }
}
