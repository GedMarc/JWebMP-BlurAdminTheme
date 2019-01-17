/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jwebmp.plugins.bluradmin.console.loggers;

import com.jwebmp.core.htmlbuilder.css.measurement.MeasurementCSSImpl;
import com.jwebmp.plugins.bootstrap.alerts.BSAlert;
import com.jwebmp.plugins.bootstrap.alerts.BSAlertSuccess;
import com.jwebmp.plugins.weblogappender.annotations.WebLogInfoMessage;

import java.util.logging.LogRecord;

/**
 * @author GedMarc
 * @since 23 Apr 2017
 */
@SuppressWarnings("unused")
public class InfoMessage
		extends WebLogInfoMessage
{


	/*
	 * Constructs a new InfoMessage
	 */
	public InfoMessage()
	{
		//Nothing needed
	}

	@Override
	public void renderMessage(LogRecord record)
	{
		BSAlert alert = new BSAlertSuccess();
		alert.getCss()
		     .getMargins()
		     .setMarginRight(new MeasurementCSSImpl(15));
		alert.addAttribute("style", "color:black;");
		alert.setText(record.getMessage());
		if (record.getParameters() != null)
		{
			for (int i = 0; i < record.getParameters().length; i++)
			{
				Object parameter = record.getParameters()[i];
				alert.setText(alert.getText(0)
				                   .toString()
				                   .replace("{" + i + "}", parameter.toString()));
			}
		}

		add(alert);
	}

}
