package com.scaler.parkinglot.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@SuperBuilder
@Setter
@Getter
public class DisplayBoards extends BaseModel{
    private Date date;

}
