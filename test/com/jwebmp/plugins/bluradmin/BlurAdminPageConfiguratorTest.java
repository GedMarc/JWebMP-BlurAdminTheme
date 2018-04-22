package com.jwebmp.plugins.bluradmin;

import com.jwebmp.Page;
import org.junit.jupiter.api.Test;

/**
 * @author Marc Magon
 */
public class BlurAdminPageConfiguratorTest

{

	public BlurAdminPageConfiguratorTest()
	{
	}

	@Test
	public void testConfigure()
	{
		Page p = new Page();
		p.getOptions()
		 .setDynamicRender(false);
		System.out.println(p.toString(true));
	}

}
