package com.psl.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.psl.bean.Assignment;
import com.psl.bean.Student;
import com.psl.bean.Subject;

public class StudentAssignmentImpl implements StudentAssignment {

	@Override
	public Map<Subject, Map<Student, Assignment>> populateData(
			String fileSubject, String fileStudent, String fileAssgnment) {
		// TODO Auto-generated method stub

		Map<Subject, Map<Student, Assignment>> mainmap = new HashMap<Subject, Map<Student, Assignment>>();
		Map<Student, Assignment> submap = new HashMap<Student, Assignment>();
		List<Assignment> ls = new ArrayList<Assignment>();
		Scanner sc = null;
		SimpleDateFormat smf = new SimpleDateFormat("dd:MM:yyyy");
		try {
			sc = new Scanner(new File(fileSubject));
			while (sc.hasNext()) {

				String st[] = sc.nextLine().split(",");
				String subname = st[0].trim();
				java.util.Date assnissuedate = smf.parse(st[1].trim());

				mainmap.put(new Subject(subname, assnissuedate),
						new HashMap<Student, Assignment>());

			}
			// System.out.println(mainmap);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			sc = new Scanner(new File(fileAssgnment));
			while (sc.hasNext()) {
				String st2[] = sc.nextLine().split(",");

				Integer rollno = Integer.parseInt(st2[0].trim());
				String subname2 = st2[1].trim();
				java.util.Date subdate = smf.parse(st2[2].trim());

				ls.add(new Assignment(rollno, subname2, subdate, 0, 0));

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Student st = null;
			sc = new Scanner(new File(fileStudent));
			while (sc.hasNext()) {
				String st3[] = sc.nextLine().split(",");

				Integer rollno3 = Integer.parseInt(st3[0].trim());
				String stdname = st3[1].trim();
				String subname = st3[2].trim();

				// st=new Student(rollno3, stdname, subname);

				for (Assignment as : ls) {
					if ((as.getRollNumber() == rollno3)
							&& (as.getSubject().equals(subname))) {
						submap.put(new Student(rollno3, stdname, subname), as);
					}
				}

			}
			// System.out.println(submap);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Map.Entry<Subject, Map<Student, Assignment>> mps : mainmap
				.entrySet()) {

			for (Map.Entry<Student, Assignment> mps2 : submap.entrySet()) {

				if (mps.getKey().getSubjectName()
						.equals(mps2.getKey().getSubject())) {

					mps.getValue().put(mps2.getKey(), mps2.getValue());
					mps.getKey().setNumberOfSubmissions(
							mps.getKey().getNumberOfSubmissions() + 1);
				}

			}
		}

		return mainmap;
	}

	@Override
	public void calculateMarks(Map<Subject, Map<Student, Assignment>> map) {
		// TODO Auto-generated method stub
		
		for(Map.Entry<Subject, Map<Student,Assignment>> mpc:map.entrySet()){
			{
			for(Map.Entry<Student, Assignment> inner:mpc.getValue().entrySet()){
				
				if(mpc.getKey().getSubjectName().equals(inner.getKey().getSubject())){
					
					java.util.Date assignissuedt=mpc.getKey().getAssignmentIssueDate();
					java.util.Date assignsubmitdt=inner.getValue().getSubmissionDate();
					
					Calendar cal=Calendar.getInstance();
					Calendar cal2=Calendar.getInstance();
					
					cal2.setTime(assignissuedt);
					
					cal.setTime(assignsubmitdt);
					int isdtdays=cal2.get(Calendar.DAY_OF_YEAR);
					int subdt=cal.get(Calendar.DAY_OF_YEAR);
					int res=subdt-isdtdays;
					//System.out.println(res);
					
					if(res<=5){
						inner.getValue().setMarksObtained(45);
						
					}
					else if(res<=10){
							inner.getValue().setMarksObtained(35);
						}
						else{
							inner.getValue().setMarksObtained(0);
							inner.getKey().setDefaulter(true);
						}
				}
				
			}
			}
		}
		
	

	}

	@Override
	public Map<Subject, Map<Student, Assignment>> generateDefaulterListSubjectWise(
			Map<Subject, Map<Student, Assignment>> map) {
		
		Map<Subject, Map<Student, Assignment>> newmp=new HashMap<Subject, Map<Student,Assignment>>();
		for(Map.Entry<Subject, Map<Student, Assignment>> ms:map.entrySet()){
			newmp.put(ms.getKey(), new HashMap<Student, Assignment>());
		}
		
		for(Map.Entry<Subject, Map<Student, Assignment>> mcc:newmp.entrySet()){
			
			for(Map.Entry<Subject, Map<Student,Assignment>> mcc2:map.entrySet()){
				for(Map.Entry<Student, Assignment> mcc3:mcc2.getValue().entrySet()){
					
					if(mcc3.getKey().getDefaulter()==true){
						mcc.getValue().put(mcc3.getKey(), mcc3.getValue());
					}
				}
			
			}
		}
		
		
		
return newmp;
	}

	@Override
	public void offerGraseMarks(Map<Subject, Map<Student, Assignment>> map) {
		// TODO Auto-generated method stub
		
		for(Map.Entry<Subject, Map<Student, Assignment>> mc:map.entrySet()){
			List<Assignment> ls= new ArrayList<Assignment>();
			for(Map.Entry<Student, Assignment> mc3:mc.getValue().entrySet()){
				ls.add(mc3.getValue());
			}
			
			
			
			ls.sort(
					
					(p,q)->{return p.getSubmissionDate().compareTo(q.getSubmissionDate());}
						);
				
				for(Assignment lsss:ls){
					lsss.setMarksObtained(lsss.getMarksObtained()+3);
					break;
				}
			
		}
			
		/*for(Assignment ls1:ls){
			System.out.println(ls1);
		}
		*/
		
		
		
		
		for(Map.Entry<Subject, Map<Student, Assignment>> mv:map.entrySet()){
			System.out.println(mv.getKey());
			System.out.println(mv.getValue());
			
		}
		//System.out.println(ls);
		
	}

	
	
}