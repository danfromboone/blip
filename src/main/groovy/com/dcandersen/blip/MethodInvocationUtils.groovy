package com.dcandersen.blip

import org.codehaus.groovy.runtime.DefaultGroovyMethods

class MethodInvocationUtils {

  static Object invokeClassMethod(String classMethod, Collection args){

    def classMethodTokens = classMethod.split('/')
    String methodName = classMethodTokens.last()
    String className = classMethodTokens.first()

    Class clazz  = Class.forName(className)

    DefaultGroovyMethods.invokeMethod(clazz, methodName, args)

  }

  static Object invokeInstanceMethod(String classMethod, Collection args){

    Object instance = args.first()
    List rest = CollectionUtils.cdr(args)

    DefaultGroovyMethods.invokeMethod(instance, classMethod, rest)

  }

  static Object invokeMethod(String classMethod, Collection args){
    if (classMethod.contains('/')){
      return invokeClassMethod(classMethod,args)
    }else{
      return invokeInstanceMethod(classMethod,args)
    }
  }

}
