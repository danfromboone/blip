package com.dcandersen.blip.element

import com.dcandersen.blip.CollectionUtils
import com.dcandersen.blip.MethodInvocationUtils
import com.dcandersen.blip.element.atom.SymbolAtom
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode
@ToString
class Expression extends Element {

  List value

  Expression(List value){
    this.value = value
  }

  Object eval(){

    def first = value.first()
    def rest = CollectionUtils.cdr(value)

    if (first instanceof SymbolAtom ){

      if (first.value == 'defun'){



      }
      else if (first.value == 'defvar'){
        String variableName = rest.first().value
        Element element = rest[1]
        Object value = element.eval()

        parent.variables.put(variableName,value)

        return value

      }else{
        def restNativeValues = rest.collect{it.eval()}
        def firstNativeValue = first.eval()

        def nativeMethodResult = MethodInvocationUtils.invokeMethod(firstNativeValue, restNativeValues)

        return nativeMethodResult
      }

    }else{
      def retVal = null
      value.each{
        retVal = it.eval()
      }
      return retVal
    }

  }

}
