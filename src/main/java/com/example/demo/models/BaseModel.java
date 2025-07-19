package com.example.demo.models;
import java.util.Date;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
//import jakarta.persistence.Id;
//import jakarta.persistence.Entity;


@Getter
@Setter
public class BaseModel {

@Id
private long id;

private Date createdAt;
private Date lastModifiedAt;
private boolean isDeleted;


}
