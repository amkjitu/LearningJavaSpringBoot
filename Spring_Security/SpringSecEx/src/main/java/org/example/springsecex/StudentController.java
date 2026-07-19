package org.example.springsecex;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private List<Student> students = new ArrayList<>(
            List.of(
                    new Student("1", "John Doe"),
                    new Student("2", "Jane Smith")
            )
    );

    @GetMapping("/csrf-token")
    public CsrfToken getToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute(CsrfToken.class.getName());
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("/student")
    public void addStudent(@RequestBody Student student) {
        students.add(student);
    }
}
