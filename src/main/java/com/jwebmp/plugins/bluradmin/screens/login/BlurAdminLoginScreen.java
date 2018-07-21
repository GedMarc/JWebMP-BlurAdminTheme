/*
 * Copyright (C) 2017 Marc Magon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jwebmp.plugins.bluradmin.screens.login;

import com.jwebmp.core.base.html.Div;
import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.utilities.StaticStrings;
import com.jwebmp.plugins.bluradmin.layout.display.DisplayScreen;
import com.jwebmp.plugins.bootstrap.buttons.BSButton;
import com.jwebmp.plugins.bootstrap.forms.BSForm;
import com.jwebmp.plugins.bootstrap.forms.controls.BSFormEmailInput;
import com.jwebmp.plugins.bootstrap.forms.controls.BSFormPasswordInput;
import com.jwebmp.plugins.bootstrap.forms.controls.BSFormTextInput;
import com.jwebmp.plugins.bootstrap.forms.groups.BSFormGroup;
import com.jwebmp.plugins.bootstrap.options.BSWidthOptions;

/**
 * @author Marc Magon
 * @since 24 Jun 2017
 */
public class BlurAdminLoginScreen
		extends DisplayScreen
{

	private static final long serialVersionUID = 1L;

	/*
	 * Constructs a new BlurAdminLoginScreen
	 */
	public BlurAdminLoginScreen()
	{
		//Nothing needed
	}

	protected Div buildSurroundingDiv()
	{
		Div block = new Div();
		block.addClass("auth-block");
		block.addClass("col-offset-md-3");
		block.addClass(BSWidthOptions.col_md_6);
		block.addClass(BSWidthOptions.col_xs_12);

		return block;
	}

	protected Div buildLoginBlock()
	{
		Div div = new Div();
		div.addClass("auth-main");
		div.setTag("main");

		Div block = new Div();
		block.addClass("auth-block");
		div.add(block);

		Link newToApp = new Link();

		newToApp.setText("New to the app? Register Today!");
		newToApp.addAttribute("href", StaticStrings.STRING_HASH);
		newToApp.addClass("auth-link");

		BSForm form = new BSForm();
		form.addClass("form-horizontal");

		form.add(buildEmailInput());
		form.add(buildPasswordInput());
		form.add(buildButtonBar());

		block.add(form);
		block.add(buildSeparator());

		return div;
	}

	protected BSFormGroup<?> buildEmailInput()
	{
		BSFormEmailInput emailLogin = new BSFormEmailInput();
		emailLogin.setPlaceholder("Email Input");
		emailLogin.setRequired();
		emailLogin.addClass(BSWidthOptions.col_xs_12);
		BSFormGroup loginGroup = new BSFormGroup(null, emailLogin, null);
		loginGroup.setAngularValidation(true);
		return loginGroup;
	}

	protected BSFormGroup<?> buildPasswordInput()
	{
		BSFormPasswordInput passwordInput = new BSFormPasswordInput();
		passwordInput.setMinimumLength(4);
		passwordInput.setRequired();
		passwordInput.setPlaceholder("Password");
		passwordInput.addClass(BSWidthOptions.col_xs_12);
		BSFormGroup passwordGroup = new BSFormGroup(null, passwordInput, null);
		passwordGroup.setAngularValidation(true);
		return passwordGroup;
	}

	protected BSFormGroup buildButtonBar()
	{
		BSFormGroup buttonGroup = new BSFormGroup();
		buttonGroup.addAttribute("style", "margin-top:5px;");
		buttonGroup.addClass(BSWidthOptions.col_xs_12);
		return buttonGroup;
	}

	public Div buildSeparator()
	{
		return new Div();
	}

	protected BSButton buildDefaultButton()
	{
		BSButton registerButton = new BSButton("");
		registerButton.addClass("btn-default btn-auth");
		return registerButton;
	}

	protected Link niceText(String text)
	{
		Link newToApp = new Link();
		newToApp.setText(text);
		newToApp.addClass("auth-link");
		newToApp.addClass(BSWidthOptions.col_xs_12);
		return newToApp;
	}

	protected Link softText(String text)
	{
		Link newToApp = new Link();
		newToApp.setText(text);
		newToApp.addClass("auth-link text-muted");
		newToApp.addClass(BSWidthOptions.col_xs_12);
		return newToApp;
	}

	protected BSFormGroup<?> buildTextInput()
	{
		BSFormTextInput textInput = new BSFormTextInput();
		textInput.setRequired();
		textInput.addClass(BSWidthOptions.col_xs_12);
		BSFormGroup<? extends BSFormGroup> enterpriseName = new BSFormGroup(null, textInput, null);
		enterpriseName.setAngularValidation(true);
		return enterpriseName;
	}
}
