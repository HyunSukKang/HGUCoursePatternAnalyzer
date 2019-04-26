package edu.handong.analysis;

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
	private Student[] students;
	private Course[] courses;
	
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
	private Student[] initiateStudentArrayFromLines(String[] lines) {
		students = new Student[numOfStudents];
		String[] tempString;
		int a = lines.length;
		int count = 0;
		int flag = 0;
		for(int i=0; i<a; i++) {
			tempString = lines[i].trim().split(", ");
			if(i == 0) {
				students[i] = new Student(tempString[1]);
				count++;
			}
			else {
				for(int j=0; j<count; j++) {
					if(tempString[1].equals(students[j].getName())) {
						flag = 1;
						break;
					}
				}
				
				if(flag == 1) {
					flag = 0;
				}
				else {
					students[count] = new Student(tempString[1]);
					count++;
				}
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
	private boolean studentExist(Student[] students, Student student) {
		
		// TODO: implement this method

		return false;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		courses = new Course[numOfCourses];
		String[] tempString;
		int a = lines.length;
		int count = 0;
		int flag = 0;
		for(int i=0; i<a; i++) {
			tempString = lines[i].trim().split(", ");
			if(i == 0) {
				courses[i] = new Course(tempString[2]);
				count++;
			}
			else {
				for(int j=0; j<count; j++) {
					if(tempString[2].equals(courses[j].getCourseName())) {
						flag = 1;
						break;
					}
				}
				
				if(flag == 1) {
					flag = 0;
				}
				else {
					courses[count] = new Course(tempString[2]);
					count++;
				}
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
	private boolean courseExist(Course[] courses, Course course) {
		
		// TODO: implement this method

		return false;
	}

}
