/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertis.demo.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.vertis.demo.domain.TimeSheet;
import com.vertis.demo.service.TimeSheetService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.util.StringUtils;

/**
 *
 * @author telfealr
 */
@Configurable(autowire = Autowire.BY_TYPE)
public class TimeSheetDeserializer extends StdDeserializer<TimeSheet> {
    @Autowired
    private TimeSheetService timeSheetService;
    
    public TimeSheetDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public TimeSheet deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
        String uid = jp.getText();

        if (!StringUtils.isEmpty(uid) && uid.matches("^\\d+$")) {
            return timeSheetService.findOne(Long.parseLong(uid));
        }

        return jp.readValueAs(TimeSheet.class);
    }
    
}
