package com.dcandersen.blip

import spock.lang.Ignore
import spock.lang.Specification

class EvaluatorSpec extends Specification {

  def 'evaluate String Expression'(){
    setup:
    String expressionString = '(plus  (plus 1 (plus 7 5 ))( plus 2 3 ) )'
    Evaluator evaluator = new Evaluator()

    when:
    def retVal = evaluator.evaluate(expressionString)

    then:
    retVal == 18
  }

  def 'evaluate multiple expressions'(){
    setup:
    String expressionString = '''
    (plus 1 7)
    (plus 2 3)
    
    '''
    Evaluator evaluator = new Evaluator()

    when:
    def retVal = evaluator.evaluate(expressionString)

    then:
    retVal == 5
  }

  def 'variables'(){
    setup:
    String expressionString = '''
    (defvar x 2)
    (+ x 3)
    '''
    Evaluator evaluator = new Evaluator()

    when:
    def retVal = evaluator.evaluate(expressionString)

    then:
    retVal == 5
  }

  def 'scoped variables'(){
    setup:
    String expressionString = '''
    (defvar y 3)
    (+ 1 (
      (defvar y 11)
      (+ 2 3)))
    (+ 2 y)
    '''
    Evaluator evaluator = new Evaluator()

    when:
    def retVal = evaluator.evaluate(expressionString)

    then:
    retVal == 5
  }

  @Ignore
  def 'function'(){
    setup:
    String expressionString = '''
    (defun my-function(x y) (+ x y))
    (my-function 2 3)
    '''
    Evaluator evaluator = new Evaluator()

    when:
    def retVal = evaluator.evaluate(expressionString)

    then:
    retVal == 5
  }


}
