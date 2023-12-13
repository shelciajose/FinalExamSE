/*
package com.example.finalExamSE.web;

import com.example.finalExamSE.entities.Student;
import com.example.finalExamSE.entities.category;
import com.example.finalExamSE.repositories.categoryRepository;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@WebAppConfiguration
class SalesControllerTest {

    Student student;

    category categorys;

    private MockMvc mockMvc;

    */
/*@Mock
    private StudentRepository studentRepository;*//*


    @Mock
    private categoryRepository categoryRepositorys;

    @Mock
    private View mockView;

    @InjectMocks
    private SalesController salesController;

    @BeforeEach
    void setUp() throws ParseException {
        student = new Student();

        student.setId(1L);
        student.setName("John");

        Date date = new SimpleDateFormat("yyyy/MM/dd").parse("2012/11/11");
        student.setDob(date);

        student.setPassed(true);
        student.setGpa(3.5);

        MockitoAnnotations.openMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(salesController).setSingleView(mockView).build();
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void findAll_listView() throws Exception {
        List<Student> students = new ArrayList<>();

        //List<category> categories = new ArrayList<>();

        //students.add(student);

        students.add(student);
        students.add(student);

        when(studentRepository.findAll()).thenReturn(students);

        mockMvc.perform(MockMvcRequestBuilders.get("/index"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attribute("listStudents", students))
                .andExpect(MockMvcResultMatchers.view().name("students"))
                .andExpect(MockMvcResultMatchers.model().attribute("listStudents", Matchers.hasSize(2)));

        verify(studentRepository, times(1)).findAll();
        verifyNoMoreInteractions(studentRepository);
    }

    @Test
    void delete() throws Exception {
        ArgumentCaptor<Long> idCaptor = ArgumentCaptor.forClass(Long.class);
        doNothing().when(studentRepository).deleteById(idCaptor.capture());

        mockMvc.perform(MockMvcRequestBuilders.get("/delete").param("id", String.valueOf(1L)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("redirect:/index"));

        assertEquals(1L, idCaptor.getValue());
        verify(studentRepository, times(1)).deleteById(1L);
    }

    @Test
    void editStudents() throws Exception {
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        mockMvc.perform(MockMvcRequestBuilders.get("/editStudents").param("id", String.valueOf(1L)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attribute("student", student))
                .andExpect(MockMvcResultMatchers.view().name("editStudents"));

        verify(studentRepository, times(1)).findById(anyLong());
        verifyNoMoreInteractions(studentRepository);
    }

    @Test
    void formStudents() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/formStudents"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("formStudents"))
                .andExpect(MockMvcResultMatchers.model().attribute("student", new Student()));
    }

    @Test
    void save() throws Exception {
        when(studentRepository.save(any(Student.class))).thenReturn(student);

        mockMvc.perform(MockMvcRequestBuilders.post("/save")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .content(EntityUtils.toString(new UrlEncodedFormEntity(Arrays.asList(
                                new BasicNameValuePair("id", "1"),
                                new BasicNameValuePair("name", "John"),
                                new BasicNameValuePair("dob", "2012-11-11"),
                                new BasicNameValuePair("passed", "on"),
                                new BasicNameValuePair("gpa", "3.5")
                        )))))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("redirect:/index"));

        verify(studentRepository, times(1)).save(student);
    }
}*/
