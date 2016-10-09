/**
 * 
 */
package com.genscript.gsscm.common.util;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.stereotype.Service;

/**
 * 用于在非Spring管理的类中获取Spring Bean对象
 * 
 * @author duanjunwei
 *
 */
@Service
@Lazy(false)
public class SpringContextHolder implements ApplicationContextAware, DisposableBean {

	private static Logger logger = LoggerFactory.getLogger(SpringContextHolder.class);

	private static ApplicationContext applicationContext;
	
	/**
	 * Register a singleton object to Spring Context.
	 * @param beanName
	 * @param obj
	 */
	public static void registerSingleton(String beanName, Object obj){
		ConfigurableApplicationContext context = (ConfigurableApplicationContext)applicationContext;
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		
		if( !beanFactory.containsSingleton(beanName)){
			beanFactory.registerSingleton(beanName, obj);
		}
	}
	
	/**
	 * if contains a singleton bean in spring context, return true.
	 * @param beanName
	 * @return
	 */
	public static boolean containsSingleton(String beanName){
		ConfigurableApplicationContext context = (ConfigurableApplicationContext)applicationContext;
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		
		return beanFactory.containsSingleton(beanName);
	}

	/**
	 * 实现ApplicationContextAware接口的context注入函数, 将其存入静态变量.
	 */
	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringContextHolder.applicationContext = applicationContext; // NOSONAR
	}

	/**
	 * 取得存储在静态变量中的ApplicationContext.
	 */
	public static ApplicationContext getApplicationContext() {
		checkApplicationContext();
		return applicationContext;
	}

	/**
	 * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		checkApplicationContext();
		return (T) applicationContext.getBean(name);
	}

	/**
	 * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
	 */
	public static <T> T getBean(Class<T> clazz) {
		checkApplicationContext();
		return applicationContext.getBean(clazz);
	}

	/**
	 * 清除applicationContext静态变量.
	 */
	public static void cleanApplicationContext() {
		applicationContext = null;
	}

	private static void checkApplicationContext() {
		if (applicationContext == null) {
			throw new IllegalStateException(
					"applicaitonContext not injected, please define SpringContextHolder in the applicationContext.xml");
		}
	}

	public static String getRootRealPath() {
		String rootRealPath = "";
		try {
			rootRealPath = getApplicationContext().getResource("").getFile().getAbsolutePath();
		} catch (IOException e) {
			logger.warn("Get root category failed.");
		}
		return rootRealPath;
	}

	public static String getResourceRootRealPath() {
		String rootRealPath = "";
		try {
			rootRealPath = new DefaultResourceLoader().getResource("").getFile().getAbsolutePath();
		} catch (IOException e) {
			logger.warn("Get root category failed.");
		}
		return rootRealPath;
	}

	@Override
	public void destroy() throws Exception {
		SpringContextHolder.cleanApplicationContext();
	}

}
