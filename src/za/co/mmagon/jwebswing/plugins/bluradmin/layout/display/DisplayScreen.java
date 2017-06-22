package za.co.mmagon.jwebswing.plugins.bluradmin.layout.display;

import java.util.ArrayList;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.plugins.bootstrap.containers.BSRow;

/**
 *
 * @author Marc Magon
 * @since 08 Apr 2017
 */
public class DisplayScreen extends Div
{

    private static final long serialVersionUID = 1L;

    private final ContentTop contentTop;
    private Div contentDiv;

    private java.util.List<BSRow> rows;

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
        add(contentTop);
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

    public ContentTop getContentTop()
    {
        return contentTop;
    }

    public void setRows(java.util.List<BSRow> rows)
    {
        this.rows = rows;
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
