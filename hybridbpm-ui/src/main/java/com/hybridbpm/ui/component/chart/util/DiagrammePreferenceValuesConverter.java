/*
 * Copyright (c) 2011-2015 Marat Gubaidullin. 
 *
 * This file is part of HYBRIDBPM.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 */
package com.hybridbpm.ui.component.chart.util;

import com.hybridbpm.core.data.chart.DiagrammePreferenceValue;
import com.vaadin.data.util.converter.Converter;
import java.util.Locale;

/**
 *
 * @author mgubaidullin
 */
@SuppressWarnings("serial")
public class DiagrammePreferenceValuesConverter implements Converter<Object, DiagrammePreferenceValue> {

    public DiagrammePreferenceValuesConverter() {
    }

    
    
    @Override
    public DiagrammePreferenceValue convertToModel(Object value, Class<? extends DiagrammePreferenceValue> targetType, Locale locale) throws ConversionException {
        return new DiagrammePreferenceValue(value.toString(), value.toString());
    }

    @Override
    public String convertToPresentation(DiagrammePreferenceValue value, Class<? extends Object> targetType, Locale locale) throws ConversionException {
        return value.getId();
    }

    @Override
    public Class<DiagrammePreferenceValue> getModelType() {
        return DiagrammePreferenceValue.class;
    }

    @Override
    public Class<Object> getPresentationType() {
        return Object.class;
    }
    
}
