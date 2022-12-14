import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Employee {
	private String id;
	private String name;
	private String meetingTime;

}

public class MainApp {
	public static void main(String[] args) {

		List<Employee> emp = new ArrayList();
		emp.add(new Employee("A1", "Avinash1", "2022-12-13 01:00:00"));
		emp.add(new Employee("A2", "Avinash2", "2022-12-13 02:00:00")); 
		emp.add(new Employee("A3", "Avinash3", "2022-12-13 03:00:00"));
		emp.add(new Employee("A4", "Avinash4", "2022-12-13 04:00:00"));
		emp.add(new Employee("A5", "Avinash5", "2022-12-13 06:00:00"));
		emp.add(new Employee("A6", "Avinash6", "2022-12-13 08:00:00"));

		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String date1 = "2022-12-13 01:59:00";
		String date2 = "2022-12-13 03:59:00";

		LocalDateTime dateTime1 = LocalDateTime.parse(date1, format);
		LocalDateTime dateTime2 = LocalDateTime.parse(date2, format);
		System.out.println(dateTime1);
		
		List<Employee> empList=emp.stream().filter(x->LocalDateTime.parse(x.getMeetingTime(), format).isAfter(dateTime1) 
				&&LocalDateTime.parse(x.getMeetingTime(), format).isBefore(dateTime2)).collect(Collectors.toList());
		

	}
}
