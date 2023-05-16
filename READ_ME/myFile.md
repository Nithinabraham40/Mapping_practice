# Welcome to readme-md-generator &#x1F44B; 
![example workflow](https://img.shields.io/badge/Eclipse-Version%3A%202022--09%20(4.25.0)-orange)
![example workflow](https://img.shields.io/badge/SpringBoot-2.2.1-yellowgreen)
![example workflow](https://img.shields.io/badge/Java-8-yellowgreen)
![example workflow](https://img.shields.io/badge/Postman-v10.13-orange)
![example workflow](https://img.shields.io/badge/Documentation-Yes-green)
![example workflow](https://img.shields.io/badge/Manitained%3F-Yes-green)
 >CLI that generate beautiful **ReadME**.md files

  :house:  <b><span style="color: blue;">Homepage</span></b>
  


 # Prerequisties

 - **Eclipse >=4.55.0**
 - **Postman >=10.13**
 


# Install
```
Maven Install
SpringTool Install
```
 # Framework And Language

 - **Framework :  SpringBoot**
 - **Language :  Java**

 # Dependencies Required

 - **spring-boot-starter-validation**
 - **spring-boot-starter-web**
 - **spring-boot-devtools**
 - **lombok**
 - **spring-boot-starter-test**
 - **spring-boot-starter-data-jpa**
 - **mysql-connector**


# Student Controller


```

RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	@PostMapping("/add")
	public ResponseEntity<String>addStrudent(@RequestBody Student student){return studentService.addStudent(student);}
		
	@GetMapping("/get")
	public ResponseEntity<List<Student>>getAllStudentAgeAbove(@RequestParam("ageabove") String age){
		
		
		return studentService.getAllStudentAgeAbove(age);
	}
	
	@PutMapping("/update/id/{id}")
	
	public ResponseEntity<String>updatelandmarkWhereStudentId(@PathVariable("id")Long id,@RequestParam("landmark") String landmark)
	{
		
		return studentService.updatelandmarkWhereStudentId(id,landmark);
	}
	
	@GetMapping("/get/laptop/id/{id}")
	
	public ResponseEntity<Laptop>getTheLaptopDetailsForStudent(@PathVariable Long id){
		return studentService.getTheLaptopDetailsForStudent(id);}
		
	
	@GetMapping ("see/allBooks")
	
	public ResponseEntity<List<Book>>seeAllBooks(){return studentService.seeAllBooks();}

	@PostMapping("book/studentid/{id}/added")
	
	public ResponseEntity<String>studentSelectBooksById(@PathVariable Long id, @RequestParam("bookids") List<Long>allIds){
		
		
		return studentService.studentSelectBooksById(id,allIds);
		
	}
	@PostMapping("add/course/studentid/{id}")
	
	public ResponseEntity<String>addTheSelectedCoursesToStudent(@PathVariable("id")Long id ,@RequestParam("courseids")List<Long>allIds ){
		
		
		return studentService.addTheSelectedCoursesToStudent(id,allIds);
	}
	
	
	
	

}
	
```



# Laptop Controller


```


@RestController
@RequestMapping("/laptop")
public class LaptopController {

	
	@Autowired
	private LaptopService laptopService;
	
	
	
	@PostMapping("/add")
	
	public ResponseEntity<String>addLaptop(@RequestBody Laptop laptop){
		
		
		return laptopService.addLaptop(laptop);
	}
	
	@DeleteMapping("delete/id/{id}")
	public ResponseEntity<String>deleteLaptopWithId(@PathVariable Long id){
		
		
		return laptopService.deleteLaptopWithId(id);
	}
}
	
```


# Course Controller


```


@RestController
@RequestMapping("/course")
public class CourseController {

	
	@Autowired
	private CourseServise courseService;
	
	
	@PostMapping("/add")
	
	private ResponseEntity<String>addCourses(@RequestBody CourseDao courseDao){
		
		
		return courseService.addCourses(courseDao);
		
	}
	
	@DeleteMapping("/delete/id/{id}")
	private ResponseEntity<String>deleteCourseById(@PathVariable("id") Long id){
		return courseService.deleteCourseById(id);
		
	}
	
	
}
	
```


# Book Controller


```



@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	
	@PostMapping("add/books/only")
	
	public ResponseEntity<String>addBookOnly(@RequestBody BookDao bookDao){
		
		
		return bookService.addBookOnly(bookDao);}	
	
	@GetMapping("get")
	
	public ResponseEntity<List<Book>>getAllBooks(){
		
		return bookService.getAllBooks();
	}
	

}

	
```

	
	


  


	







	



# Database Used

<details>
<summary><b><span style="color: white;">Clickme</span></b> &#x1F4F2; </summary>

*Mysql*



</details>


# Student Model

```
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentID;
	private String name;
	private String age;
	private String phoneNumber;
	private String branch;
	private String department;

	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_address_addressId")
	@JsonIgnore
	private Address address;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "student")
	
	private List<Book>allBooks;

}
	
```


# Address Model

```
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_address")
public class Address {
	
	@Id
	@SequenceGenerator(name = "address_sequence",sequenceName = "address_sequence",allocationSize = 1,initialValue = 1000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "address_sequence")
    private Long addressId;
	private String landmark;
	private String zipcode;
	private String district;
	private String state;
	private String country;
	


}
	
```

# Laptop Model

```

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_laptop")
public class Laptop {

	@Id
	@SequenceGenerator(name = "laptop_sequence",sequenceName = "laptop_sequence",allocationSize = 1,initialValue = 4000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "laptop_sequence")
	private Long laptopID;
	private String laptopName;
	private String laptopBrand;
	private Integer laptopPrice;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_student_studentId")
	@JsonIgnore
	private Student student;
	
}
	
```


# Book Model

```

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_book")
public class Book {
	
	
	@Id
	@SequenceGenerator(name = "book_sequence",sequenceName = "book_sequence",allocationSize = 1,initialValue = 200)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "book_sequence")
	private Long ID;

	private String title;
	private String author;
	private String description;
	private String price;

	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_student_student_id")
	@JsonIgnore

	private Student student;

}
	
```


# Course Model

```

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_course")
public class Course {

	
	@Id
	@SequenceGenerator(name = "course_sequence",sequenceName = "course_sequence",allocationSize = 1,initialValue = 8000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_sequence")
	private Long CourseId;
	private String title;
	private String description;
	private String duration;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Course_student",joinColumns = @JoinColumn(name="course_id"),inverseJoinColumns = @JoinColumn(name="student_id"))
	List<Student> studentList;
	
}
	
```

 # Database Design For Student Model

 - **Primary Key :  Student_id**
 - **Generationstrategy: IDENTITY**
  
  - **Mapping with address:one to one uni directional**
  - **Mapping with books:one to many bi directional**
 - **Columns Used:  Student_id,studen_name , branch, age,department,Ph_number,fk_address_addressId**

 # Database Design For Laptop Model

 - **Primary Key :  laptop_id**
 - **Generationstrategy:  SEQUENCE**
  
  - **Mapping with Student:one to one uni directional**
  
  
 - **Columns Used:  laptop_id,laptop_name , brand, prize,fk_student_studentId**
 


# Database Design For Address Model

 - **Primary Key :  address_id**
 - **Generationstrategy:  Sequence**
 
  

  
 - **Columns Used:  address_id,landmark, district,zipcode ,state,country**

# Database Design For Book Model

 - **Primary Key :  book_id**
 - **Generationstrategy:  Sequence**
 
  
 - **Mapping with student:many to one bi directional**
  
 - **Columns Used:  book_id,book_name, tittle,author ,description,prize**

# Database Design For Course Model

 - **Primary Key :  course_id**
 - **Generationstrategy:  Sequence**
 
  
 - **Mapping with student:many to many uni  directional**
  
 - **Columns Used:  course_id tittle,description,duration**



# Summary

 Spring Project for practice Mapping with models Student,laptop,address,course,book
The project will have the following features
**Add students**,
**students can purchase books and course**,
**add and delete books and courses**,
. Along with these proper validations are also provided.Used CRUD operation,Custom finders and Custom Query
to do necessary operations.






# :handshake:  Contributing
  Contributions,issues and features request are welcome! 
  

  #


  This *README* was generated with &#x2764;&#xFE0F; by <b><span style="color: blue;">readme-md-generator</span></b> 










   
  
  

