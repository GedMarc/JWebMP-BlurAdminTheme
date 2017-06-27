package za.co.mmagon.jwebswing.plugins.bluradmin.layout.display;

import za.co.mmagon.jwebswing.base.html.Div;

/**
 *
 * @author Marc Magon
 * @since 08 Apr 2017
 */
public class DisplayScreen extends Div
{

    private static final long serialVersionUID = 1L;

    private final ContentTop contentTop;
    private final Div contentDiv;

    /*
     * Constructs a new DisplayScreen
     */
    public DisplayScreen()
    {
        addAttribute("style", "width:100%;height:100%;");
        setID("DisplayScreen");
        addClass("al-content");
        addAttribute("style", "overflow-y:auto;");
        contentTop = new ContentTop();

        contentDiv = new Div();
        contentDiv.addClass("auth-main");
        contentDiv.addAttribute("autoscroll", "true");
        contentDiv.addAttribute("autoscroll-body-top", null);

        add(contentTop);
        add(contentDiv);
    }

    public Div getContentDiv()
    {
        return contentDiv;
    }

    public ContentTop getContentTop()
    {
        return contentTop;
    }

    @Override
    public void init()
    {
        if (!isInitialized())
        {

        }
        super.init();
    }

}
