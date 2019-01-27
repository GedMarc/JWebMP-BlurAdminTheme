module com.jwebmp.plugins.bluradmin {
	requires com.google.guice;
	requires com.google.guice.extensions.servlet;
	requires com.jwebmp.guicedinjection;
	requires com.jwebmp.guicedservlets;
	requires com.jwebmp.logmaster;
	requires java.logging;
	requires com.jwebmp.core;
	requires com.jwebmp.plugins.bootstrap;
	requires com.jwebmp.plugins.moment;
	requires com.jwebmp.plugins.plusastab;
	requires com.jwebmp.plugins.jqlayout;
	requires com.jwebmp.plugins.weblogappender;
	requires com.jwebmp.plugins.angularslimscroll;
	requires com.jwebmp.plugins.toastr;
	requires java.validation;
	requires com.jwebmp.core.angularjs;
	exports com.jwebmp.plugins.bluradmin;

	provides com.jwebmp.core.services.IPageConfigurator with com.jwebmp.plugins.bluradmin.BlurAdminPageConfigurator;

}
