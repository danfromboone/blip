package com.dcandersen.blip

import com.dcandersen.blip.element.atom.BooleanAtom
import com.dcandersen.blip.element.atom.NumberAtom
import com.dcandersen.blip.element.atom.StringAtom
import com.dcandersen.blip.element.atom.SymbolAtom
import com.dcandersen.blip.element.Expression

class ExpressionParser {


  def parseExpression(String expression){
    NestedTokenizer nestedTokenizer = new NestedTokenizer()
    List tokens = nestedTokenizer.tokenize(expression)
    parse(tokens, null)
  }

  def parse(List<String> tokenList, Expression expression){

    if (!expression){
      expression = new Expression()
    }

    def subList = tokenList.collect {
      def subElement

      if (it instanceof List) {
        subElement = new Expression()

        parse(it, subElement)
      } else if (it.startsWith("'")) {
        subElement = new StringAtom(it)
      } else if (it == 'true') {
        subElement = new BooleanAtom(true)
      } else if (it == 'false') {
        subElement = new BooleanAtom(false)
      } else if (it.isNumber()) {
        subElement = new NumberAtom(it)
      } else {
        subElement = new SymbolAtom(it)
      }
      subElement.parent = expression
      subElement
    }

    expression.value = subList

    expression
    }





}
