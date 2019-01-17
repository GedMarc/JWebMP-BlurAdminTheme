package com.jwebmp.plugins.bluradmin;

import com.jwebmp.core.Page;
import org.junit.jupiter.api.Test;

/**
 * @author GedMarc
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
