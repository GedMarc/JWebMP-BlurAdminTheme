package za.co.mmagon.jwebswing.plugins.bluradmin.layout;

import com.google.inject.servlet.SessionScoped;
import za.co.mmagon.jwebswing.plugins.bluradmin.layout.display.DisplayScreen;

/**
 *
 * @author Marc Magon
 * @since 22 Jun 2017
 */
@SessionScoped
public class BlurAdminSessionProperties
{

    private DisplayScreen currentScreen;

    /*
     * Constructs a new BlurAdminSessionProperties
     */
    public BlurAdminSessionProperties()
    {
        //Nothing needed
    }

    public DisplayScreen getCurrentScreen()
    {
        return currentScreen;
    }

    public void setCurrentScreen(DisplayScreen currentScreen)
    {
        this.currentScreen = currentScreen;
    }

}
