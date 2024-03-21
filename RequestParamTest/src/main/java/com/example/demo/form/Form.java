// Form.java

package com.example.demo.form;

import java.time.LocalDate;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class Form {
	private String name;
	private Integer age;
	
	@DateTimeFormat(iso = @DateTimeFormat.ISO.DATE)
	private LocalDate birth;
}
