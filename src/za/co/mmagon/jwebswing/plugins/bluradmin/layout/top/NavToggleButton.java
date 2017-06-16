package za.co.mmagon.jwebswing.plugins.bluradmin.layout.top;

import com.google.inject.Inject;
import za.co.mmagon.jwebswing.base.html.Link;
import za.co.mmagon.jwebswing.plugins.bluradmin.layout.BlurAdminLayout;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.events.JQLayoutAddToggleButtonFeature;

/**
 * A Default Navigation Toggle Button
 *
 * @author Marc Magon
 * @since 19 Apr 2017
 */
public class NavToggleButton extends Link<NavToggleButton>
{

    private static final long serialVersionUID = 1L;

    NavToggleButton()
    {
    }

    /*
     * Constructs a new NavToggleButton
     */
    @Inject
    public NavToggleButton(BlurAdminLayout layout)
    {
        addClass("collapse-menu-link fa fa-navicon");
        setID("NavToggleMenuButton");
        JQLayoutAddToggleButtonFeature atbf = new JQLayoutAddToggleButtonFeature(layout.getWest(), this);
        addFeature(atbf);
        //JQLayoutFeature feat = new JQLayoutFeature(layout)
    }
}
