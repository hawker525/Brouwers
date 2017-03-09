package be.vdab.web;

import be.vdab.datasource.DataSourceConfig;
import be.vdab.repositories.RepositoriesConfig;
import be.vdab.restservices.RestControllersConfig;
import be.vdab.services.ServicesConfig;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * Created by Maarten Westelinck on 2/02/2017 for brouwers.
 */
public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {DataSourceConfig.class, RepositoriesConfig.class, ServicesConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{RestControllersConfig.class, ControllersConfig.class};
    }

    @Override
    protected Filter[] getServletFilters(){
        return new Filter[]{new OpenEntityManagerInViewFilter(),new CharacterEncodingFilter("UTF-8")};
    }
}
