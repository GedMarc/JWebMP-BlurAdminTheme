package za.co.mmagon.jwebswing.plugins.bluradmin;

import com.armineasy.injection.abstractions.GuiceInjectorModule;
import com.armineasy.injection.interfaces.GuiceDefaultBinder;
import com.google.inject.Singleton;
import com.google.inject.servlet.SessionScoped;
import za.co.mmagon.jwebswing.plugins.bluradmin.components.LongRunningProgressBar;
import za.co.mmagon.jwebswing.plugins.bluradmin.console.WebLogAppender;

/**
 *
 * @author Marc Magon
 * @since 02 Jul 2017
 */
public class BlurAdminBinder extends GuiceDefaultBinder
{

    /*
     * Constructs a new BlurAdminBinder
     */
    public BlurAdminBinder()
    {
        //Nothing needed
    }

    @Override
    public void onBind(GuiceInjectorModule module)
    {
        module.bind(WebLogAppender.class).in(Singleton.class);
        module.bind(LongRunningProgressBar.class).in(SessionScoped.class);
    }
}
