package com.dcandersen.blip

import spock.lang.Specification

class MethodInvocationUtilsSpec extends Specification {


//  def "invoke class method"(){
//
//    setup:
//    String classMethod = 'java.lang.Math/max'
//    def args = [3,5]
//
//    when:
//    def retVal = MethodInvocationUtils.invokeMethod(classMethod,args)
//
//    then:
//    retVal == 8
//
//
//  }

  def "invoke instance method"(){

    setup:
    String classMethod = 'plus'
    List args = [3 as BigDecimal,5]

    when:
    def retVal = MethodInvocationUtils.invokeMethod(classMethod,args)

    then:
    retVal == 8


  }


}
