function solution(ingredient) {
    
    let count = 0;
    let array = new Array;
    
    for (let i of ingredient) {
        array.push(i)
        if (array.slice(-4).join('') == '1231') {
            array.splice(-4);
            count+=1;
        }
    }
    
    return count;
}

***
  정규식으로 판별하는 것도,
  reduce를 이용하는 것도 해 보았으나 시간이 너무 느려
  위와 같이 하는 것만이 통과하였다.
***
