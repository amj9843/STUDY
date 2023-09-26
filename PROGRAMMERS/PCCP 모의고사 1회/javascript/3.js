function solution(queries) {
    function miniSolution(array) {
        let [n, p] = array
        let stack = []

        p--
        while (n>1) {
            stack.push(p%4)
            p = parseInt(p/4)
            n--
        }

        while (stack.length > 0) {
            num = stack.splice(-1)
          
            if (num == 0) return 'RR'
            if (num == 3) return 'rr'
        }
        return 'Rr'
    }
    return queries.map(obj => miniSolution(obj))
}
