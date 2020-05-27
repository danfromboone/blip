package com.dcandersen.blip

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/*

  converts s-expressions to nested string lists

 */

@ToString
@EqualsAndHashCode
class NestedTokenizer {

  def tokenize(String expression) {
    expression = expression.replaceAll('\\s', ' ')
    StringTokenizer stringTokenizer = new StringTokenizer(expression, '() ', true)

    def list = []
    tokenize(stringTokenizer, list)
  }

  def tokenize(StringTokenizer stringTokenizer, List list) {

    while (stringTokenizer.hasMoreTokens()) {
      String stringToken = stringTokenizer.nextToken()

      if (stringToken == '(') {

        List subList = []
        list.add(subList)
        tokenize(stringTokenizer, subList)
      }else if (stringToken == ')') {
        break
      } else if (stringToken == ' '){
        // do nothing. ignore whitespace
      }else{
        list.add(stringToken)
      }
    }

    list
  }
}