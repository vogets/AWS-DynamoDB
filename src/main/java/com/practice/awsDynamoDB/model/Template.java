package com.practice.awsDynamoDB.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "ui_template")
public class Template implements Serializable {
    @DynamoDBHashKey(attributeName = "ui_key")
    private String ui_key;
    CompositeControls composite_controls;
    private String templatename;
    List< Object > section_attributes;

    public String getUi_key() {
        return ui_key;
    }

    public void setUi_key(String ui_key) {
        this.ui_key = ui_key;
    }

    @DynamoDBAttribute
    public CompositeControls getComposite_controls() {
        return composite_controls;
    }

    public void setComposite_controls(CompositeControls composite_controls) {
        this.composite_controls = composite_controls;
    }

    @DynamoDBAttribute
    public String getTemplatename() {
        return templatename;
    }

    public void setTemplatename(String templatename) {
        this.templatename = templatename;
    }

    @DynamoDBAttribute
    public List<Object> getSection_attributes() {
        return section_attributes;
    }

    public void setSection_attributes(List<Object> section_attributes) {
        this.section_attributes = section_attributes;
    }
}
