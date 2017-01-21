package testpackage;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		if (o1.getScore()>o2.getScore()) {
			return 1;
		}
		if (o1.getScore()>o2.getScore()) {
			return -1;
		}
		return 0;
	}

}
