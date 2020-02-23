

package com.psl.util;

import java.util.List;
import java.util.Map;

import com.psl.bean.Assignment;
import com.psl.bean.Student;
import com.psl.bean.Subject;

public interface StudentAssignment {
	
	Map<Subject,Map<Student , Assignment>> populateData(String fileSubject,String fileStudent,String fileAssgnment);
	
	void calculateMarks(Map<Subject,Map<Student , Assignment>> map);//calculate marks for student .student should submit the assignment within 5 (to get 45 marks out of fifty)days otherwise 10 days 35 marks after 10 days anyone whoe submitt the assignment would get 0 and declared as defaulter.
	
	Map<Subject,Map<Student , Assignment>> generateDefaulterListSubjectWise(Map<Subject,Map<Student , Assignment>> map);

	void offerGraseMarks(Map<Subject,Map<Student , Assignment>> map);//offer grase marks to two students who have submitted most earliest(grase marks =3) .Do this for every subject
	
	
}
