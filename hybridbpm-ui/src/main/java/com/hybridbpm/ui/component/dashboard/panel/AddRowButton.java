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
package com.hybridbpm.ui.component.dashboard.panel;

import com.vaadin.annotations.DesignRoot;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

@DesignRoot
@SuppressWarnings("serial")
public class AddRowButton extends Button {

    public AddRowButton(Button.ClickListener clickListener) {
        addClickListener(clickListener);
        setIcon(FontAwesome.PLUS_CIRCLE);
        setStyleName(ValoTheme.BUTTON_LINK);
        addStyleName(ValoTheme.BUTTON_TINY);
        setDescription("Add row");
    }
    

}
