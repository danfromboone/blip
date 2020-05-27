package com.dcandersen.blip

import com.dcandersen.blip.NestedTokenizer
import spock.lang.Specification

class NestedTokenizerSpec extends Specification {


  def tokenize(){
    setup:
    String expression= '''( aaaa bbbb (cccc 2 3 ) ( dddd 1 2 ) 11 )'''

    NestedTokenizer tokenizer = new NestedTokenizer()

    when:
    def tokens = tokenizer.tokenize(expression)

    then:
    println tokens
    true
    tokens == [['aaaa','bbbb',['cccc','2','3'],['dddd','1','2'],'11']]

  }

  def tokenize1(){
    setup:
    String expression= '''
    aaa
    ( print aaa)
    ( add 1 2 3)
    '''

    NestedTokenizer tokenizer = new NestedTokenizer()

    when:
    def tokens = tokenizer.tokenize(expression)

    then:
    tokens == [
      'aaa',
      ['print','aaa'],
      ['add','1','2','3']
    ]

  }

  def tokenize4(){
    setup:
    String expression= '''
(
    aaa
    ( asdf aaa)
    ( add 1 2 3)
 )
    '''

    NestedTokenizer tokenizer = new NestedTokenizer()

    when:
    def tokens = tokenizer.tokenize(expression)

    then:
    tokens == [
      [
        'aaa',
        ['asdf','aaa'],
        ['add','1','2','3']
      ]
    ]

  }

  def tokenize2(){
    setup:
    String expression= '''(plus (plus 2 3) (plus 1 2 ))'''

    NestedTokenizer tokenizer = new NestedTokenizer()

    when:
    def tokens = tokenizer.tokenize(expression)

    then:
    tokens == [
     [
       'plus',['plus','2','3'],['plus','1','2']
     ]
    ]

  }

}
