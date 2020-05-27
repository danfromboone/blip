package com.dcandersen.blip.element.atom

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@ToString
@EqualsAndHashCode
class StringAtom extends Atom{

  String value

  StringAtom(String value ){
    this.value = value
  }

  Object eval(){
    value
  }

}
