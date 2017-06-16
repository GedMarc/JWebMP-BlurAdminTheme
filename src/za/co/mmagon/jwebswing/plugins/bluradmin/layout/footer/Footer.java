package za.co.mmagon.jwebswing.plugins.bluradmin.layout.footer;

import com.armineasy.injection.GuiceContext;
import java.util.Set;
import za.co.mmagon.jwebswing.base.html.*;

/**
 *
 * @author Marc Magon
 * @since 05 Apr 2017
 */
public class Footer extends Div
{

    private static final long serialVersionUID = 1L;

    /*
     * Constructs a new Footer
     */
    public Footer()
    {
        //Nothing needed
        setID("PageFooter");
        setTag("footer");
        addClass("al-footer clearfix");
    }

    public Div addFooterRight(String text, String iconClassName)
    {
        Div div = new Div();
        div.addClass("al-footer-right");
        div.setText(text + " <i class=\"" + iconClassName + "\"></i>");
        return div;
    }

    private Div footerMainDiv;

    public Div addFooterMain(String copyrightText)
    {
        footerMainDiv = new Div();
        footerMainDiv.addClass("al-footer-main clearfix");
        Div copyright = new Div();
        copyright.addClass("al-copy");
        copyright.setText("Armin Software 2017");
        footerMainDiv.add(copyright);
        return footerMainDiv;
    }

    private List shareList;

    public List addShareList()
    {
        if (footerMainDiv == null)
        {
            addFooterMain("");
        }
        shareList = new List(false);
        shareList.addClass("al-share clearfix");
        footerMainDiv.add(shareList);
        return shareList;
    }

    public ListItem addShareItem(String iconClass, String url)
    {
        ListItem li = new ListItem();
        Link link = new Link(url, "_blank");
        li.add(link);

        Italic i = new Italic();
        i.addClass(iconClass);
        link.add(i);

        shareList.add(li);
        return li;
    }

    @Override
    public void preConfigure()
    {
        if (!isConfigured())
        {
            Set<Class<? extends BlurAdminFooter>> footers = GuiceContext.reflect().getSubTypesOf(BlurAdminFooter.class);

        }
        super.preConfigure();
    }
}
