package com.dcandersen.blip

class CollectionUtils {

  static List cdr(List list){

    if (list.size() > 0) {

      List newList = list.clone()
      newList.remove(0)
      newList

    }else{
      return []
    }
  }

  static Object car(List list) {
    if (list.size() > 0) {
      return list.first()
    }else{
      return null
    }
  }

}
