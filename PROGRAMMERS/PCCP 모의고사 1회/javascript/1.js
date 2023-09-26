function solution(input_string) {
    const ALPHABET = Array.from({ length: 26 }, (v, i) => String.fromCharCode(i + 97));
    input_string = (input_string.length>2600) ? input_string.slice(0, 2600) : input_string;

    let answer = ALPHABET.filter((alphabet)=>{
        const regexp = new RegExp(`${alphabet}+[^${alphabet}]+${alphabet}+`)
        return regexp.test(input_string)
    }).join('');

    if (answer === '') answer = 'N';

    return answer
}
