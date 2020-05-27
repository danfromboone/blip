package com.dcandersen.blip.element.atom

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@ToString
@EqualsAndHashCode
class SymbolAtom extends Atom{

  String value

  SymbolAtom(String value ){
    this.value = value
  }

  Map subMap = [
    '+':'plus'
  ]

  Object eval(){

    def variableValue = resolveVariable(value)

    if (variableValue){
      return variableValue
    }

    return subMap.get(value) ?: value

   // return value
  }

}
