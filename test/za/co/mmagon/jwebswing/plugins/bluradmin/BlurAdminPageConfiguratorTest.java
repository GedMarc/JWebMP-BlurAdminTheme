package za.co.mmagon.jwebswing.plugins.bluradmin;

import org.junit.jupiter.api.Test;
import za.co.mmagon.BaseTestClass;
import za.co.mmagon.jwebswing.Page;

/**
 *
 * @author Marc Magon
 */
public class BlurAdminPageConfiguratorTest extends BaseTestClass
{

    public BlurAdminPageConfiguratorTest()
    {
    }

    @Test
    public void testConfigure()
    {
        Page p = getInstance();
        p.getOptions().setDynamicRender(false);
        System.out.println(p.toString(true));
    }

}
