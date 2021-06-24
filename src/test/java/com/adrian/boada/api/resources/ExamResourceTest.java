package com.adrian.boada.api.resources;

import com.adrian.boada.api.entities.exam;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExamResourceTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private RestService restService;
    private exam product;

    @Before
    public void before() {
        product = new exam();
        this.product.setModel("chevrolet");
        this.product.setBrand("aveo");
        this.product.setPrice(10.000);
    }

    @Test
    public void getAllExam() {
        String json = restService
                .restBuilder(new RestBuilder<String>().clazz(String.class))
                .path(ExamResource.EXAM).get().build();
        System.out.println(json);
    }

    @Test
    public void getById() {
        String json = restService
                .restBuilder(new RestBuilder<String>().clazz(String.class))
                .path(ExamResource.EXAM).path(ExamResource.ID).expand(1).get().build();
        System.out.println(json);
    }



    @Test
    public void createExam() {
        String json = restService
                .restBuilder(new RestBuilder<String>().clazz(String.class))
                .path(ExamResource.EXAM).body(this).post().build();
        System.out.println(json);

    }

    @Test
    public void editExam() {
        this.product.setBrand("bugatti");
        this.product.setModel("2");
        this.product.setId(1);
        this.product.setPrice(120.000);
        String json = restService
                .restBuilder(new RestBuilder<String>().clazz(String.class))
                .path(ExamResource.EXAM).path(ExamResource.ID)
                .expand(1).body(this).put().build();
        System.out.println(json);
    }

    @Test
    public void deleteExam() {
        String json = restService
                .restBuilder(new RestBuilder<String>().clazz(String.class))
                .path(ExamResource.EXAM).path(ExamResource.ID).expand(1).delete().build();
        System.out.println(json);
    }
}