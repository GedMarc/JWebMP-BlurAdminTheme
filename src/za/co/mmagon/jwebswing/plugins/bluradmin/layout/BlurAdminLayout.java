package za.co.mmagon.jwebswing.plugins.bluradmin.layout;

import com.google.inject.Inject;
import za.co.mmagon.jwebswing.PlaceHolder;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.JQLayout;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.LayoutResponsiveBootstrapSize;

/**
 *
 * @author Marc Magon
 * @since 07 Jun 2017
 */
public class BlurAdminLayout extends JQLayout
{

    private static final long serialVersionUID = 1L;

    /*
     * Constructs a new BlurAdminLayout
     */
    @Inject
    @SuppressWarnings("")
    public BlurAdminLayout(BlurAdminBody body)
    {
        super(body);
        getNorth().getContentDiv().add(new PlaceHolder("PageTop"));
        getWest().getContentDiv().add(new PlaceHolder("SideBar"));
        getSouth().getContentDiv().add(new PlaceHolder("PageFooter"));

        getNorth().getOptions().setTogglerLength_open(0);
        getNorth().getOptions().setTogglerLength_closed(0);
        getNorth().getOptions().setSpacing_closed(0);
        getNorth().getOptions().setSpacing_open(0);
        // getNorth().getOptions().setResizable(false);
        //getNorth().getOptions().setClosable(false);
        getNorth().getOptions().setMinSize(66);

        getWest().getOptions().setMaxSize(180);
        getWest().getOptions().setMinSize(180);
        getWest().getOptions().setResponsive(true);
        getWest().getOptions().setTogglerLength_open(0);
        getWest().getOptions().setTogglerLength_closed(0);
        getWest().getOptions().setSpacing_closed(0);
        getWest().getOptions().setSpacing_open(0);
        //getWest().getOptions().setResizable(false);
        //getWest().getOptions().setClosable(false);
        getWest().getOptions().setResponsiveWhen(LayoutResponsiveBootstrapSize.Small);

        getSouth().getOptions().setMaxSize(80);
        getSouth().getOptions().setMinSize(80);
        //getSouth().getOptions().setResizable(false);
        //getSouth().getOptions().setClosable(false);
        getSouth().getOptions().setTogglerLength_open(0);
        getSouth().getOptions().setTogglerLength_closed(0);
        getSouth().getOptions().setSpacing_closed(0);
        getSouth().getOptions().setSpacing_open(0);

        Div mainContent = new Div();
        mainContent.addClass("al-main");
        mainContent.add(new PlaceHolder("DisplayScreen"));
        getCenter().getContentDiv().add(mainContent);
    }
}
