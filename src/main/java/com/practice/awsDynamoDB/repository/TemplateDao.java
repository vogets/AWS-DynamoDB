package com.practice.awsDynamoDB.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.awsDynamoDB.model.SongsPojo;
import com.practice.awsDynamoDB.model.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TemplateDao {
    @Autowired
    private DynamoDBMapper mapper;

    @Autowired
    private DynamoDB db;

    @Autowired
    ObjectMapper objMapper;


    public List<Template> getTemplatebyId(String ui_key) throws Exception {
        System.out.println("Dao called");
        List<Template> templateList = new ArrayList<>();
        Table table = db.getTable("ui_template");
        QuerySpec spec = new QuerySpec().withKeyConditionExpression("ui_key = :ui_key")
                .withValueMap(new ValueMap().withString(":ui_key",ui_key));

        ItemCollection<QueryOutcome> items = table.query(spec);

        Iterator<Item> iterator = items.iterator();

        while (iterator.hasNext()) {
            templateList.add(objMapper.readValue(iterator.next().toJSON(),Template.class));
        }
        return templateList;
    }



}
