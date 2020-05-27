package com.dcandersen.blip

class Evaluator {


  static Object evaluate(String expressionString){

  //  ExpressionTokenizer expressionTokenizer = new ExpressionTokenizer(expressionString)
    ExpressionParser expressionParser = new ExpressionParser()
    def expression = expressionParser.parseExpression(expressionString)
    expression.eval()

  }

}
