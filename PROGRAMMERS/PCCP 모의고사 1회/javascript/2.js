function solution(ability) {
    const categoryCount = ability[0].length
    
    function miniSolution(array, count) {
        let score = 0;
        
        if (count == 1) return Math.max(...array.map(obj => obj[categoryCount-count]))
        
        array.forEach((fixed, i, src) => {
            const rest = [...src.slice(0,i), ...src.slice(i+1)]
            const item = miniSolution(rest, count-1)
            if (fixed[categoryCount-count] + item > score) score = fixed[categoryCount-count] + item;
        })
        return score;
    }
    
    const answer = miniSolution(ability, categoryCount)
    
    return answer;
}
