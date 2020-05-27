package com.dcandersen.blip

import com.dcandersen.blip.element.atom.NumberAtom
import com.dcandersen.blip.element.Expression
import com.dcandersen.blip.element.atom.SymbolAtom
import spock.lang.Specification

class ExpressionParserSpec extends Specification {

  def parse(){
    setup:
    ExpressionParser parser = new ExpressionParser()
    String expression= '''(plus (plus 2 3) (plus 1 2 ))'''

    when:
    def retVal = parser.parseExpression(expression)

    def expectedValue = new Expression([new Expression(
      [
        new SymbolAtom('plus'),
        new Expression([
          new SymbolAtom('plus'),
          new NumberAtom(2),
          new NumberAtom(3)
        ]),
        new Expression([
          new SymbolAtom('plus'),
          new NumberAtom(1),
          new NumberAtom(2)
        ])
      ]
    )])

    then:
    retVal == expectedValue

  }

  def parse2(){
    setup:
    ExpressionParser parser = new ExpressionParser()
    String expression= '''
      (plus 1 7)
      (plus 2 3)
    '''

    when:
    def retVal = parser.parseExpression(expression)

    def expectedValue = new Expression([
        new Expression([
          new SymbolAtom('plus'),
          new NumberAtom(1),
          new NumberAtom(7)
        ]),
        new Expression([
          new SymbolAtom('plus'),
          new NumberAtom(2),
          new NumberAtom(3)
        ])
      ])

    then:
    retVal == expectedValue

  }

}
