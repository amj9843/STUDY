import re

def solution(input_string) :
    ALPHABET = list(map(chr, range(97, 123)))
    
    if len(input_string) > 2600 : 
        input_string = input_string[0:2600]
    
    answer = ''.join(filter(
        lambda alphabet : re.compile(f'{alphabet}+[^{alphabet}]+{alphabet}').search(input_string), ALPHABET)
                    )
    
    if answer == '' :
        answer = 'N';

    return answer
