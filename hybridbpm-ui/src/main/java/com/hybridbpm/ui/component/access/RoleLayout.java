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
package com.hybridbpm.ui.component.access;

import com.hybridbpm.core.data.access.Role;
import com.hybridbpm.ui.component.TranslatedField;
import com.hybridbpm.model.Translated;
import com.hybridbpm.ui.HybridbpmUI;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;
import java.util.logging.Level;
import java.util.logging.Logger;

@DesignRoot
@SuppressWarnings("serial")
public final class RoleLayout extends VerticalLayout {

    private TextField nameTextField;
    private TranslatedField titleTextField;
    private TranslatedField descriptionTextField;
    private BeanFieldGroup<Role> binder = new BeanFieldGroup<>(Role.class);

    public RoleLayout(Role role) {
        Design.read(this);
        if (role == null) {
            role = new Role();
            role.setTitle(new Translated(""));
            role.setDescription(new Translated(""));
        }
        binder.setItemDataSource(role);
        binder.bind(nameTextField, "name");
        binder.bind(titleTextField, "title");
        binder.bind(descriptionTextField, "description");
        binder.setBuffered(true);

        if (role.getName() != null) {
            nameTextField.setReadOnly(true);
        }
    }

    public void save() {
        try {
            binder.commit();
            HybridbpmUI.getAccessAPI().saveRole(binder.getItemDataSource().getBean());
        } catch (FieldGroup.CommitException ex) {
            Logger.getLogger(RoleLayout.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

}
