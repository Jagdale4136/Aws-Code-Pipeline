package com.demo.service;

import com.demo.model.Student;
import com.demo.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository repository;

    @InjectMocks
    private StudentService service;

    @Test
    void shouldSaveStudent() {

        Student student =
                new Student(1L, "John", "john@test.com", 25);

        when(repository.save(any(Student.class)))
                .thenReturn(student);

        Student result = service.save(student);

        assertEquals("John", result.getName());

        verify(repository).save(student);
    }
}