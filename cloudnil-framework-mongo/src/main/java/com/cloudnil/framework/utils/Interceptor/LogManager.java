package com.cloudnil.framework.utils.Interceptor;

import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * <p>ClassName: LogManager</p>
 * <p>Description: Service层的操作日志记录AOP类</p>
 * @author 史绍虎
 * <p>Date: 2012-5-23 下午5:04:48</p>
 */
@Component
@Aspect
public class LogManager {
	
	private final static Logger log=LoggerFactory.getLogger(LogManager.class); 
	/**
	 * <p>MethodName: pointcut</p>
	 * <p>Description: 定义统一公用切入点</p>
	 */
	@Pointcut("execution(* *..service..*Impl.*(..))")  
    public void pointcut(){
		
	}
	/**
	 * <p>MethodName: before</p>
	 * <p>Description: 切点动作前置通知</p>
	 */
	@Before("pointcut()")
	public void before(JoinPoint jp) {
		
	}
	/**
	 * <p>MethodName: after</p>
	 * <p>Description: 切点动作后置通知</p>
	 */
	@After("pointcut()")
	public void after(JoinPoint jp) {
		String className=jp.getTarget().getClass().getName();
		String methodName=jp.getSignature().getName();
		Object [] args=jp.getArgs();
		StringBuffer argsStrbuf=new StringBuffer();
		
		argsStrbuf.append("\n=======================================操作记录=======================================\n");
		argsStrbuf.append("类名：");
		argsStrbuf.append(className);
		argsStrbuf.append("\n");
		argsStrbuf.append("方法：");
		argsStrbuf.append(methodName);
		argsStrbuf.append("  参数：");
		//argsStrbuf.append(this.getParams(args));
		argsStrbuf.append("\n");
		argsStrbuf.append("=====================================================================================\n");
		log.info(argsStrbuf.toString());
	}
	/**
	 * <p>MethodName: getParams</p>
	 * <p>Description: 获取截取的PO子类对象中各字段的值</p>
	 * @param args 
	 * @return 各字段值组成的字符串
	 */
//	private String getParams(Object [] args){
//		Method m;
//		Method [] ms;
//		StringBuffer sb=new StringBuffer("[");
//		for(int i=0;i<args.length;i++){
//			Object obj=args[i];
//			if(obj instanceof PO||obj instanceof Criteria){
//				sb.append(obj.getClass().getSimpleName());
//				sb.append(":(");
//				ms=obj.getClass().getDeclaredMethods();
//				for(int j=0;j<ms.length;j++){
//					m=ms[j];
//					if(m.getName().startsWith("get")&&!"get".equals(m.getName())){
//						Object result=null;
//						try {
//							result=m.invoke(obj);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//						if(result!=null&&!"".equals(result)){
//							sb.append(m.getName().substring(3).toLowerCase());
//							sb.append("=");
//							sb.append(result);
//							sb.append(",");
//						}
//					}
//				}
//				sb.deleteCharAt(sb.length()-1);
//				sb.append(")");
//			}else{
//				sb.append(obj);
//			}
//			if(i!=args.length-1){
//				sb.append(",");
//			}
//		}
//		sb.append("]");
//		return sb.toString();
//	}
}
