package com.practice.awsDynamoDB.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@DynamoDBDocument
public class CompositeControls implements Serializable {
    ArrayList< Object > year_and_months = new ArrayList < Object > ();
    ArrayList < Object > address = new ArrayList < Object > ();

    @DynamoDBAttribute
    public ArrayList<Object> getYear_and_months() {
        return year_and_months;
    }

    public void setYear_and_months(ArrayList<Object> year_and_months) {
        this.year_and_months = year_and_months;
    }
    @DynamoDBAttribute
    public ArrayList<Object> getAddress() {
        return address;
    }

    public void setAddress(ArrayList<Object> address) {
        this.address = address;
    }
}
