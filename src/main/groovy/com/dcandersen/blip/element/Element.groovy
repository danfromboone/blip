package com.dcandersen.blip.element

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode
@ToString
class Element {

  Element parent

  List items

  Map variables = [:]

  // map of string for name and list for argument names
  Map<String,List<String>> functions = [:]

  Object resolveVariable(String variableName){
    def variableValue = variables.get(variableName)

    if (!variableValue){
      variableValue = parent?.resolveVariable(variableName)
    }

    variableValue
  }

  Object eval(){

  }

}
