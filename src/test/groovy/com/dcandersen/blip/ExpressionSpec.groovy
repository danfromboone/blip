package com.dcandersen.blip

import com.dcandersen.blip.element.Expression
import com.dcandersen.blip.element.atom.NumberAtom
import com.dcandersen.blip.element.atom.SymbolAtom
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import spock.lang.Specification

@EqualsAndHashCode
@ToString
class ExpressionSpec extends Specification {


  def expression(){

    setup:
    Expression expression =
    new Expression([new Expression(
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

    when:
    Object retVal = expression.eval()

    then:
    retVal == 8


  }

  def another(){
    setup:
    Expression expression = new Expression([
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

    when:
    Object retVal = expression.eval()

    then:
    retVal == 5

  }

}
