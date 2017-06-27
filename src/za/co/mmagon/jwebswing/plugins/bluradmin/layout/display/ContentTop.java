package za.co.mmagon.jwebswing.plugins.bluradmin.layout.display;

import com.google.inject.servlet.SessionScoped;
import za.co.mmagon.jwebswing.Event;
import za.co.mmagon.jwebswing.base.html.*;
import za.co.mmagon.jwebswing.base.html.attributes.LinkAttributes;

/**
 *
 * @author Marc Magon
 * @since 21 Jun 2017
 */
@SessionScoped
public class ContentTop extends Div
{

    private static final long serialVersionUID = 1L;

    private final H1 header;
    private final List breadCrumblist;

    /*
     * Constructs a new ContentTop
     */
    public ContentTop()
    {
        this.header = new H1();
        header.addAttribute("style", "display:inline;");
        this.breadCrumblist = new List(false);

        addClass("content-top clearfix");
        breadCrumblist.addClass("breadcrumb al-breadcrumb");

        add(header);
        add(breadCrumblist);
    }

    public H1 getHeader()
    {
        return header;
    }

    public List getBreadCrumblist()
    {
        return breadCrumblist;
    }

    public void clearCrumbs()
    {
        breadCrumblist.getChildren().clear();
    }

    public ListItem addCrumb(String crumb)
    {
        return addCrumb(crumb, null);
    }

    public ListItem addCrumb(String crumb, Event event)
    {
        ListItem li = new ListItem();
        if (event != null)
        {
            Link link = new Link<>();
            li.add(link);
            link.setText(crumb);
            link.addEvent(event);
            link.addAttribute(LinkAttributes.HRef, "#");
        }
        else
        {
            li.setText(crumb);
        }
        getBreadCrumblist().add(li);
        return li;
    }

}
