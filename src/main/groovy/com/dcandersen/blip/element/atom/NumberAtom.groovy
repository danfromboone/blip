package com.dcandersen.blip.element.atom

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@ToString
@EqualsAndHashCode
class NumberAtom extends Atom{

  BigDecimal value

  NumberAtom(String numberString){
    value = new BigDecimal(numberString)
  }

  NumberAtom(Number number){
    value = number as BigDecimal
  }

  Object eval(){
    value
  }

}
