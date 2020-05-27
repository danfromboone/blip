package com.dcandersen.blip.element.atom

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@ToString
@EqualsAndHashCode
class BooleanAtom extends Atom{

  BooleanAtom value

  BooleanAtom(java.lang.Boolean value){
    this.value = value
  }

  Object eval(){
    value
  }

}
