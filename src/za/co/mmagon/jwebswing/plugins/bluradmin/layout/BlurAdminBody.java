package za.co.mmagon.jwebswing.plugins.bluradmin.layout;

import za.co.mmagon.guiceinjection.GuiceContext;
import za.co.mmagon.jwebswing.base.html.Body;
import za.co.mmagon.jwebswing.utilities.RegularExpressionsDTO;

/**
 *
 * @author Marc Magon
 * @since 07 Jun 2017
 */
public class BlurAdminBody extends Body
{

    private static final long serialVersionUID = 1L;

    /*
     * Constructs a new BlurAdminBody
     */
    protected BlurAdminBody()
    {
        //Nothing needed
    }

    @Override
    public void init()
    {
        if (!isInitialized())
        {
	        GuiceContext.getInstance(BlurAdminLayout.class);
	        addDto("regex", new RegularExpressionsDTO().addDefaults());
        }
        super.init();
    }

}
