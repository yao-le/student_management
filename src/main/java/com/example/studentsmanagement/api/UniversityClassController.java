package com.example.studentsmanagement.api;

import com.example.studentsmanagement.exceptions.InvalidUniversityClassException;
import com.example.studentsmanagement.model.UniversityClass;
import com.example.studentsmanagement.service.UniversityClassService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/class")
public class UniversityClassController {

  private final UniversityClassService universityClassService;

  @Autowired
  public UniversityClassController(UniversityClassService universityClassService) {
    this.universityClassService = universityClassService;
  }

  @GetMapping
  public List<UniversityClass> getAllClasses() {
    return universityClassService.getAllClasses();
  }

  @PostMapping
  @RequestMapping("/add")
  public ResponseEntity<String> addClass(@RequestBody UniversityClass universityClass) {
    try {
      UniversityClass savedUniversityClass = universityClassService.addClass(universityClass);
      return ResponseEntity.ok("Added class. " + savedUniversityClass.toString());
    } catch (InvalidUniversityClassException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }
}
