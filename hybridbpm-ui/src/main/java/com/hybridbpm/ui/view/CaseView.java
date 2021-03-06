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
package com.hybridbpm.ui.view;

import com.hybridbpm.core.util.DashboardConstant;
import com.hybridbpm.ui.component.AbstractTableLayout;
import com.hybridbpm.ui.component.bpm.CaseListLayout;
import com.hybridbpm.ui.component.bpm.StartProcessLayout;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Responsive;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;

@DesignRoot
@SuppressWarnings("serial")
public final class CaseView extends AbstractView implements View, Button.ClickListener, TabSheet.SelectedTabChangeListener, TabSheet.CloseHandler {

    public static final String VIEW_URL = DashboardConstant.VIEW_URL_CASES;
    public static final String TITLE = "Cases";
    public static final String ICON = FontAwesome.BRIEFCASE.name();
    public static final Integer ORDER = Integer.MAX_VALUE - 6;

    public VerticalLayout panelLayout;
    public TabSheet tabSheet;

    private final StartProcessLayout startProcessLayout = new StartProcessLayout();
    private final CaseListLayout myCaseInProgressLayout = new CaseListLayout(CaseListLayout.CASE_LIST.IN_PROGRESS);
    private final CaseListLayout myCaseDoneLayout = new CaseListLayout(CaseListLayout.CASE_LIST.DONE);

    public CaseView() {
        Design.read(this);
        Responsive.makeResponsive(panelLayout);
        tabSheet.setSizeFull();
        tabSheet.addTab(startProcessLayout, "Start case", FontAwesome.MAGIC);
        tabSheet.addTab(myCaseInProgressLayout, "In progress", FontAwesome.BRIEFCASE);
        tabSheet.addTab(myCaseDoneLayout, "Done", FontAwesome.ARCHIVE);
        tabSheet.setSelectedTab(myCaseInProgressLayout);
        tabSheet.addSelectedTabChangeListener(this);
        tabSheet.setCloseHandler(this);
        startProcessLayout.refreshTable();
        startProcessLayout.setTabSheet(tabSheet);
        myCaseInProgressLayout.setTabSheet(tabSheet);
        myCaseDoneLayout.setTabSheet(tabSheet);
    }

    @Override
    public void enter(ViewChangeEvent event) {
        if (tabSheet.getSelectedTab() instanceof AbstractTableLayout) {
            ((AbstractTableLayout) tabSheet.getSelectedTab()).refreshTable();
        }
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
    }

    @Override
    public void selectedTabChange(TabSheet.SelectedTabChangeEvent event) {
        Component comp = event.getTabSheet().getSelectedTab();
        if (comp instanceof AbstractTableLayout) {
            ((AbstractTableLayout) comp).refreshTable();
        }
    }

    @Override
    public void onTabClose(TabSheet tabsheet, Component tabContent) {
        tabsheet.removeComponent(tabContent);
        tabsheet.setSelectedTab(0);
    }

}
