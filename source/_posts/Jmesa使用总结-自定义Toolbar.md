title: Jmesa使用总结-自定义Toolbar
date: 2016-07-12 11:08:11
categories: [前端]
tags: [Java, Jmesa]
---
#web.xml引入jmesa
```xml
<context-param>
	<param-name>jmesaMessagesLocation</param-name>
	<param-value>messages</param-value>
</context-param>
<context-param>
	<param-name>jmesaPreferencesLocation</param-name>
	<param-value>jmesa.properties</param-value>
</context-param>
```
<!-- more -->
#定义Toolbar
```java
package org.zaozaool.ui;

import org.jmesa.core.CoreContext;
import org.jmesa.view.html.HtmlUtils;
import org.jmesa.view.html.toolbar.AbstractItemRenderer;
import org.jmesa.view.html.toolbar.HtmlToolbar;
import org.jmesa.view.html.toolbar.ImageItem;
import org.jmesa.view.html.toolbar.MaxRowsItem;
import org.jmesa.view.html.toolbar.ToolbarItem;
import org.jmesa.view.html.toolbar.ToolbarItemRenderer;
import org.jmesa.view.html.toolbar.ToolbarItemType;
import org.jmesa.web.WebContext;

/**
 * 
 * @author zaozaool
 */
public class TestListToolbar extends HtmlToolbar {

    @Override
    public String render() {
        ImageItem item = new ImageItem();
        item.setCode("Search");
        item.setTooltip("Search");
        item.setImage(getImage("out/search_.jpg", getWebContext(), getCoreContext()));
        item.setOnmouseout("$(this).attr('src','" + getImage("out/search_.jpg", getWebContext(), getCoreContext()) + "')");
        item.setOnmouseover("$(this).attr('src','" + getImage("search.jpg", getWebContext(), getCoreContext()) + "')");
        item.setAlt("Search");
        item.setAction("javascript:queryMember()");
        ToolbarItemRenderer renderer = new Render(item, getCoreContext());
        item.setToolbarItemRenderer(renderer);
        addToolbarItem(item);

        addToolbarItem(ToolbarItemType.FIRST_PAGE_ITEM);
        addToolbarItem(ToolbarItemType.PREV_PAGE_ITEM);
        addToolbarItem(ToolbarItemType.NEXT_PAGE_ITEM);
        addToolbarItem(ToolbarItemType.LAST_PAGE_ITEM);

        addToolbarItem(ToolbarItemType.PAGE_NUMBER_ITEMS);

        MaxRowsItem maxRowsItem = (MaxRowsItem) addToolbarItem(ToolbarItemType.MAX_ROWS_ITEM);
        if (getMaxRowsIncrements() != null) {
            maxRowsItem.setIncrements(getMaxRowsIncrements());
        }

        return super.render();

    }

    private static String getImage(String image, WebContext webContext, CoreContext coreContext) {
        String imagesPath = HtmlUtils.imagesPath(webContext, coreContext);
        return imagesPath + image;
    }

    private static class Render extends AbstractItemRenderer {

        public Render(ToolbarItem item, CoreContext coreContext) {
            setToolbarItem(item);
            setCoreContext(coreContext);
        }

        public String render() {
            ToolbarItem item = getToolbarItem();
            return item.enabled();
        }
    }

}
```

#jsp使用jmesa标签
```jsp
<%@ taglib prefix="jmesa" uri="/WEB-INF/MyTagLib/jmesa.tld"%> 

<jmesa:struts2TableModel toolbar="org.zaozaool.ui.TestListToolbar" id="tableTag" var="item" maxRows="50" items="${list}" maxRowsIncrements="50,100,200" limit="${limit}">
	<jmesa:htmlTable>
		<jmesa:htmlRow>
			<jmesa:htmlColumn width="1%" property="fack" filterable="false" sortable="false" headerEditor="org.jmesa.worksheet.editor.WorksheetCheckboxHeaderEditor">
				<input type="checkbox" id="chk" name="id" value="${item.id}"/>
			</jmesa:htmlColumn>
			<jmesa:htmlColumn property="name" title="Name" filterable="false" sortable="false"/>
		</jmesa:htmlRow>
	</jmesa:htmlTable>
</jmesa:struts2TableModel>
```

![效果展示](https://zaozaool.github.io/pic/jmesa.PNG)

[jmesa.tld](https://zaozaool.github.io/tld/jmesa.tld)

[Jmesa On Google Code](https://code.google.com/archive/p/jmesa/)