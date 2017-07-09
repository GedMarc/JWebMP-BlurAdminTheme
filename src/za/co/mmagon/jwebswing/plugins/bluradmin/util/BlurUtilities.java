package za.co.mmagon.jwebswing.plugins.bluradmin.util;

import com.armineasy.injection.GuiceContext;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.atmosphere.cpr.AtmosphereResource;
import za.co.mmagon.jwebswing.Event;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.plugins.toastr.ToastrFeature;
import za.co.mmagon.jwebswing.plugins.toastr.ToastrType;
import za.co.mmagon.logger.LogFactory;

/**
 *
 * @author Marc Magon
 * @since 28 Jun 2017
 */
public class BlurUtilities
{

    private static final Logger log = LogFactory.getLog(BlurUtilities.class.getName());

    private static final BlurUtilities instance = new BlurUtilities();

    /*
     * Constructs a new BlurUtilities
     */
    private BlurUtilities()
    {
        //Nothing needed
    }

    public static BlurUtilities getInstance()
    {
        return instance;
    }

    public void pushToast(ToastrType type, String title, String message)
    {
        try
        {
            AtmosphereResource resource = GuiceContext.getInstance(AtmosphereResource.class);
            AjaxResponse response = new AjaxResponse();
            ToastrFeature toast;
            response.getFeatures().add(toast = new ToastrFeature(type, title, message).setTiny(true));
            resource.write(response.toString());
        }
        catch (NullPointerException e)
        {
            log.log(Level.SEVERE, "Can't find atmosphere resource - {0}", e.getLocalizedMessage());
        }
    }

    public void pushUpdate(ComponentHierarchyBase... comp)
    {
        try
        {
            AtmosphereResource resource = GuiceContext.getInstance(AtmosphereResource.class);
            AjaxResponse response = new AjaxResponse();
            for (ComponentHierarchyBase componentHierarchyBase : comp)
            {
                response.addComponent(componentHierarchyBase);
            }
            resource.write(response.toString());
        }
        catch (NullPointerException e)
        {
            log.log(Level.SEVERE, "Can't find atmosphere resource - {0}", e.getLocalizedMessage());
        }
    }

    public void pushUpdate(Feature... comp)
    {
        try
        {
            AtmosphereResource resource = GuiceContext.getInstance(AtmosphereResource.class);

            AjaxResponse response = new AjaxResponse();
            for (Feature componentHierarchyBase : comp)
            {
                response.getFeatures().add(componentHierarchyBase);
            }
            resource.write(response.toString());
        }
        catch (NullPointerException e)
        {
            log.log(Level.SEVERE, "Can't find atmosphere resource - {0}", e.getLocalizedMessage());
        }
    }

    public void pushUpdate(Event... comp)
    {
        try
        {
            AtmosphereResource resource = GuiceContext.getInstance(AtmosphereResource.class);

            AjaxResponse response = new AjaxResponse();
            for (Event componentHierarchyBase : comp)
            {
                response.getEvents().add(componentHierarchyBase);
            }
            resource.write(response.toString());
        }
        catch (NullPointerException e)
        {
            log.log(Level.SEVERE, "Can't find atmosphere resource - {0}", e.getLocalizedMessage());
        }
    }

}
