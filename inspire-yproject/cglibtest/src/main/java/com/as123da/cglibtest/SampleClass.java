package com.as123da.cglibtest;

import java.lang.reflect.Method;

import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.proxy.CallbackHelper;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.proxy.NoOp;
import net.sf.cglib.reflect.FastClass;
import net.sf.cglib.reflect.FastMethod;
import net.sf.cglib.util.ParallelSorter;

public class SampleClass {
	private String value;
	/** 
	* @return value 
	*/
	public String getValue() {
		return value;
	}

	/** 
	* @param value 要设置的 value 
	*/
	public void setValue(String value) {
		this.value = value;
	}

	public String test(String id) {
		System.out.println("hello world");
		return "hello world";
	}

	public static void main(String[] args) throws Exception {
		// 类aop
		// testEnhancer();

		// 方法可控aop
		//testInvocationHandler();
		
		// 通过callback过滤特定方法
		//testCallbackFilter();
		
		
		//类生成器
		//testBeanGenerator();
		
		// 数组并行排序
		//testParallelSorter();
		
		
		//
		testFastClass();
	}

	/**
	 * @Title: testEnhancer
	 * @Description: TODO(用来测试,类aop)
	 * @param 入参
	 * @return void 返回类型
	 * @author （作者） linbowen
	 * @throws @date
	 *             2018年6月15日 上午9:38:05
	 * @version V1.0
	 */
	public static void testEnhancer() {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(SampleClass.class);
		enhancer.setCallback(new MethodInterceptor() {
			@Override
			public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
				System.out.println("before method run...");
				Object result = proxy.invokeSuper(obj, args);
				System.out.println("after method run...");
				return result;
			}
		});
		SampleClass sample = (SampleClass) enhancer.create();
		sample.test(null);
	}

	/**
	 * @Title: testInvocationHandler
	 * @Description: TODO(通过invocationhandler 设置 aop可控)
	 * @param @throws
	 *            Exception 入参
	 * @return void 返回类型
	 * @author （作者） linbowen
	 * @throws @date
	 *             2018年6月15日 上午9:38:36
	 * @version V1.0
	 */
	public static void testInvocationHandler() throws Exception {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(SampleClass.class);
		enhancer.setCallback(new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
					return "hello cglib";
				} else {
					throw new RuntimeException("Do not know what to do");
				}
			}
		});
		SampleClass proxy = (SampleClass) enhancer.create();
		System.out.println(proxy.test(null));
		;
		proxy.toString();
		// Assert.assertEquals("hello cglib", proxy.test(null));
		// Assert.assertEquals("Hello cglib", proxy.toString());

	}

	/** 
	* @Title: testCallbackFilter 
	* @Description: TODO(过滤特定方法) 
	* @param @throws Exception    入参
	* @return void    返回类型
	* @author （作者） linbowen
	* @throws
	* @date 2018年6月15日 上午10:08:15 
	* @version V1.0   
	*/
	public static void testCallbackFilter() throws Exception {
		Enhancer enhancer = new Enhancer();
		CallbackHelper callbackHelper = new CallbackHelper(SampleClass.class, new Class[0]) {
			@Override
			protected Object getCallback(Method method) {
				if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
					return new FixedValue() {
						@Override
						public Object loadObject() throws Exception {
							return "Hello cglib1";
						}
					};
				} else {
					return NoOp.INSTANCE;
				}
			}
		};
		enhancer.setSuperclass(SampleClass.class);
		enhancer.setCallbackFilter(callbackHelper);
		enhancer.setCallbacks(callbackHelper.getCallbacks());
		SampleClass proxy = (SampleClass) enhancer.create();
		System.out.println(proxy.test(null));
		System.out.println(proxy.toString());
		;
		;
		// Assert.assertEquals("Hello cglib", proxy.test(null));
		// Assert.assertNotEquals("Hello cglib",proxy.toString());
		System.out.println(proxy.hashCode());
	}
	
	
	
	
	
	/** 
	* @Title: testBeanGenerator 
	* @Description: TODO(动态生成类) 
	* @param @throws Exception    入参
	* @return void    返回类型
	* @author （作者） linbowen
	* @throws
	* @date 2018年6月15日 上午10:10:11 
	* @version V1.0   
	*/
	public static void testBeanGenerator() throws Exception{
	    BeanGenerator beanGenerator = new BeanGenerator();
	    beanGenerator.addProperty("value",String.class);
	    Object myBean = beanGenerator.create();
	    Method setter = myBean.getClass().getMethod("setValue",String.class);
	    setter.invoke(myBean,"Hello cglib");

	    Method getter = myBean.getClass().getMethod("getValue");
	  //  Assert.assertEquals("Hello cglib",getter.invoke(myBean));
	    System.out.println(getter.invoke(myBean));
	}
	
	
	
	/** 
	* @Title: testParallelSorter 
	* @Description: TODO(并行排序) 
	* @param @throws Exception    入参
	* @return void    返回类型
	* @author （作者） linbowen
	* @throws
	* @date 2018年6月15日 上午10:20:47 
	* @version V1.0   
	*/
	public static void testParallelSorter() throws Exception{
	    Integer[][] value = {
	            {4, 3, 9, 0},
	            {2, 1, 6, 0}
	    };
	    ParallelSorter.create(value).mergeSort(0);
	    for(Integer[] row : value){
	        int former = -1;
	        for(int val : row){
	            if(former < val);
	            former = val;
	        }
	    }
	   
	    
	    for (int i = 0; i < value.length; i++) {
	    	for (int j = 0; j < value[i].length; j++) {
				System.out.print(value[i][j]+" ");
			}
	    	System.out.println();
		}
	    
	}
	
	
	
	/** 
	* @Title: testFastClass 
	* @Description: TODO(通过对对象的调用转化为对method的调用,加快速度) 
	* @param @throws Exception    入参
	* @return void    返回类型
	* @author （作者） linbowen
	* @throws
	* @date 2018年6月15日 上午10:34:22 
	* @version V1.0   
	*/
	public static void testFastClass() throws Exception{
	    FastClass fastClass = FastClass.create(SampleClass.class);
	    FastMethod fastMethod = fastClass.getMethod("getValue",new Class[0]);
	    SampleClass bean = new SampleClass();
	    bean.setValue("Hello world");
	    System.out.println(fastMethod.invoke(bean, new Object[0]));
	    //assertEquals("Hello world",fastMethod.invoke(bean, new Object[0]));
	}
	
	
}