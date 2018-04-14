package com.jwebmp.plugins.bluradmin;

import com.jwebmp.BaseTestClass;
import com.jwebmp.Page;
import org.junit.jupiter.api.Test;

/**
 * @author Marc Magon
 */
public class BlurAdminPageConfiguratorTest
		extends BaseTestClass
{

	public BlurAdminPageConfiguratorTest()
	{
	}

	@Test
	public void testConfigure()
	{
		Page p = getInstance();
		p.getOptions()
		 .setDynamicRender(false);
		System.out.println(p.toString(true));
	}

}
