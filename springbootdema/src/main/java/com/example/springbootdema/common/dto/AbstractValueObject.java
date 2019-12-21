package com.example.springbootdema.common.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@SuppressWarnings("serial")
public abstract class AbstractValueObject implements IValueObject {
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}