package com.scaler.parkinglot.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.Random;

@SuperBuilder
@Setter
@Getter
public class BaseModel {
    public int id;
    public Date createdAt;
    public Date updatedAt;
    public BaseModel(){
        this.id = new Random().nextInt(1, 100);
    }
}
