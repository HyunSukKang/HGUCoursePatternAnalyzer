package edu.handong.analysis;

import java.util.ArrayList;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {
	
	private String[] lines = {	"1999-1, JC Nam, Java Programming",
								"1999-2, JC Nam, Programming Language Theory",
								"1999-1, JC Nam, Data Structures",
								"2001-1, JC Nam, Database Systems",
								"2018-1, SB Lim, Java Programming",
								"2018-2, SB Lim, Programming Language Theory",
								"2019-1, SB Lim, Data Structures",
								"2019-1, SB Lim, Algorithm Analysis",
								"2018-1, SJ Kim, Java Programming",
								"2018-2, SJ Kim, Programming Language Theory",
								"2019-1, SJ Kim, Logic Design",
								"2019-1, SJ Kim, Algorithm Analysis",
							};

	private int numOfStudents;
	private int numOfCourses;
	private ArrayList<Student> students;
	private ArrayList<Course> courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
	
		students = initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}
		
		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private ArrayList<Student> initiateStudentArrayFromLines(String[] lines) {
		students = new ArrayList<Student>();
		String[] tempString;
		Student student;
		int a = lines.length;
		boolean flag;
//		int count = 0;
		for(int i=0; i<a; i++) {
			tempString = lines[i].trim().split(", ");
			student = new Student(tempString[1]);
			flag = studentExist(students, student);
			if(flag == false) {
				students.add(student);
//				count++;
			}
		}
		
		return students;

	}

	/**
	 * This method check if there is the same name of the second argument in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(ArrayList<Student> students, Student student) {
		int l = students.size();
		int flag = 0;
		for(int i=0; i<l; i++) {
//			if(students[i] == null) {
//				break;
//			}
			if(students.get(i).getName().equals(student.getName())) {
				flag = 1;
				break;
			}
		}
		if(flag == 1) return true;
		else return false;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private ArrayList<Course> initiateCourseArrayFromLines(String[] lines) {
		courses = new ArrayList<Course>();
		String[] tempString;
		Course course;
		int a = lines.length;
		boolean flag;
//		int count = 0;
		for(int i=0; i<a; i++) {
			tempString = lines[i].trim().split(", ");
			course = new Course(tempString[2]);
			flag = courseExist(courses, course);
			if(flag == false) {
				courses.add(course);
//				count++;
			}
		}
		
		return courses;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(ArrayList<Course> courses, Course course) {
		int l = courses.size();
		int flag = 0;
		for(int i=0; i<l; i++) {
//			if(courses[i] == null) {
//				break;
//			}
			if(courses.get(i).getCourseName().equals(course.getCourseName())) {
				flag = 1;
				break;
			}
		}
		if(flag == 1) return true;
		else return false;	
	}
}
