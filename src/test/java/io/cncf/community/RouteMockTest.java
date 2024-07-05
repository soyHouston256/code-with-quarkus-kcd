package io.cncf.community;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import io.cncf.community.dto.PersonDto;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestHTTPEndpoint(PersonResource.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RouteMockTest {
        
    @Test
    @Order(1)
    public void getPersonTest() {     
        given()
        .when()
            .get()
        .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("size()", is(2))
            .body("[0].id", is("664f4bf9c70dd20036c229cb"))
            .body("[0].name", is("Luis Falero"))
            .body("[0].email", is("lfalero@gmail.com"))
            .body("[1].id", is("664f4c10c70dd20036c229cc"))
            .body("[1].name", is("Jean Lopez"))
            .body("[1].email", is("jlopez@gmail.com"));
    }

    @Test
    @Order(2)
    public void createPersonTest() {     
        given()
            .body(new PersonDto("", ""))
            .contentType(ContentType.JSON)
        .when()
            .post()
        .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("id", is("664f4bf9c70dd20036c229cb"))
            .body("name", is("Luis Falero"))
            .body("email", is("lfalero@gmail.com")); 
    }

    @Test
    @Order(3)
    public void updatePersonTest() {     
        given()
            .body(new PersonDto("", ""))
            .contentType(ContentType.JSON)
        .when()
            .put("/664f4bf9c70dd20036c229cb")
        .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("id", is("664f4bf9c70dd20036c229cb"))
            .body("name", is("Luis Falero"))
            .body("email", is("lfalero@gmail.com")); 
    }

    @Test
    @Order(4)
    public void deletePersonTest() {     
        given()
        .when()
            .delete("/664f4bf9c70dd20036c229cb")
        .then()
            .statusCode(204); 
    }

}
