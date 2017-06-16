package za.co.mmagon.jwebswing.plugins.bluradmin.layout.display;

import com.armineasy.injection.GuiceContext;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;
import java.util.ArrayList;
import java.util.Map;
import za.co.mmagon.jwebswing.base.html.*;
import za.co.mmagon.jwebswing.plugins.bootstrap.containers.BSRow;

/**
 *
 * @author Marc Magon
 * @since 08 Apr 2017
 */
public class DisplayScreen extends Div
{

    private static final long serialVersionUID = 1L;

    private String title;
    private Div contentDiv;

    private java.util.List<BSRow> rows;

    /*
     * Constructs a new DisplayScreen
     */
    public DisplayScreen()
    {
        //Nothing needed
        addAttribute("style", "width:100%");
        setID("DisplayScreen");
        addClass("al-content");
        addAttribute("style", "overflow-y:auto;");

        //setTitle("Display Screen Title");

        /*
         * breadcrumbs.clear(); breadcrumbs.put("Home", new ListItem("Home")); breadcrumbs.put("Login Screen", new ListItem("Login"));
         */
    }

    public java.util.List<BSRow> getRows()
    {
        if (rows == null)
        {
            rows = new ArrayList<>();
        }
        return rows;
    }

    public Div getContentDiv()
    {
        if (contentDiv == null)
        {
            setContentDiv(new Div());
        }
        return contentDiv;
    }

    public void setContentDiv(Div contentDiv)
    {
        getChildren().remove(this.contentDiv);
        this.contentDiv = contentDiv;
        if (this.contentDiv != null)
        {
            contentDiv.addAttribute("autoscroll", "true");
            contentDiv.addAttribute("autoscroll-body-top", null);
        }
    }

    public void setRows(java.util.List<BSRow> rows)
    {
        this.rows = rows;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    @Override
    public void init()
    {
        if (!isInitialized())
        {
            Div contentTopTag = new Div();
            contentTopTag.setTag("content-top");

            Div contentTop = new Div();
            contentTop.addClass("content-top clearfix");
            if (getTitle() != null)
            {

                contentTopTag.add(contentTop);

                H1 heading = new H1(getTitle());
                contentTop.add(heading);
                heading.addClass("al-title");
                add(contentTopTag);
            }

            List breadcrumbList = new List();
            breadcrumbList.addClass("breadcrumb al-breadcrumb");

            Map<String, ListItem> breadcrumbs = GuiceContext.getInstance(Key.get(new TypeLiteral<Map<String, ListItem>>()
            {
            }, Names.named("Breadcrumbs")));

            for (Map.Entry<String, ListItem> entry : breadcrumbs.entrySet())
            {
                String key = entry.getKey();
                ListItem value = entry.getValue();
                breadcrumbList.add(value);
            }

            contentTop.add(breadcrumbList);

            for (BSRow row : getRows())
            {
                getContentDiv().add(row);
            }
            add(getContentDiv());
        }
        super.init();
    }

}
