package com.psl.main;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.psl.bean.Assignment;
import com.psl.bean.Student;
import com.psl.bean.Subject;
import com.psl.util.StudentAssignment;
import com.psl.util.StudentAssignmentImpl;
public class Client {
	public static void main(String[] args) {
	
		StudentAssignmentImpl obj= new StudentAssignmentImpl();
		Map<Subject, Map<Student, Assignment>> map=obj.populateData("subject.txt", "student.txt","submission.txt");
	/*	
		for(Map.Entry<Subject, Map<Student, Assignment>> mps:map.entrySet()){
			System.out.println(mps.getKey());
			
			System.out.println(mps.getValue());
			
			System.out.println("\n");
		}*/
		
		obj.calculateMarks(map);
		/*for(Map.Entry<Subject, Map<Student, Assignment>> mps:map.entrySet()){
			System.out.println(mps.getKey());
			
			System.out.println(mps.getValue());
			
			System.out.println("\n");
		}*/
		Map<Subject, Map<Student, Assignment>> ma=obj.generateDefaulterListSubjectWise(map);
		
		/*for(Map.Entry<Subject, Map<Student, Assignment>> mps:ma.entrySet()){
			System.out.println(mps.getKey());
			
			System.out.println(mps.getValue());
			
			System.out.println("\n");
		}*/
		
		obj.offerGraseMarks(map);
		
	}  
		
	}
	
	